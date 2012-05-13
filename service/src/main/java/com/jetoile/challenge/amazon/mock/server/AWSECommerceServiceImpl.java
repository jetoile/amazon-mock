/*
 * Copyright (c) 2011 Khanh Tuong Maudoux <kmx.petals@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jetoile.challenge.amazon.mock.server;

import javax.jws.WebParam;
import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.List;

import com.amazon.webservices.awsecommerceservice._2011_08_01.AWSECommerceServicePortType;
import com.amazon.webservices.awsecommerceservice._2011_08_01.BrowseNodeLookupRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.BrowseNodes;
import com.amazon.webservices.awsecommerceservice._2011_08_01.Cart;
import com.amazon.webservices.awsecommerceservice._2011_08_01.CartAddRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.CartClearRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.CartCreateRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.CartGetRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.CartModifyRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.Item;
import com.amazon.webservices.awsecommerceservice._2011_08_01.ItemLookupRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.ItemSearchRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.Items;
import com.amazon.webservices.awsecommerceservice._2011_08_01.OperationRequest;
import com.amazon.webservices.awsecommerceservice._2011_08_01.SimilarityLookupRequest;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kmx.petals@gmail.com
 */
public class AWSECommerceServiceImpl implements AWSECommerceServicePortType {
	private final static Logger LOGGER = LoggerFactory.getLogger( AWSECommerceServiceImpl.class );

	@Override
	public void itemSearch(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") ItemSearchRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<ItemSearchRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Items",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Items>> items) {
		LOGGER.debug( "=========== method {} called with {}", "itemSearch", items );

		//TODO : http://s3.amazonaws.com/awsdocs/Associates/2011-08-01/prod-adv-api-gsg-2011-08-01.pdf

		// TODO : mock
		if ( request != null && request.get( 0 ) != null && request.get( 0 ).getSearchIndex().equals( "DVDs" ) ) {
			// TODO : verifier les valeurs possibles sur Amazon... cf. http://associates-amazon.s3.amazonaws.com/signed-requests/helper/index.html

			String keywords = request.get( 0 ).getKeywords();

			if ( items.value == null ) {
				items = new Holder<List<Items>>( new ArrayList<Items>() );
			}
			Items items_res = new Items();
			Item item = new Item();
			item.setASIN( "123" );

			items_res.getItem().add( item );
			items.value.add( items_res );
			LOGGER.debug( "=========== {}", items );

		}
		LOGGER.debug( "=========== end method {} called", "itemSearch" );

	}

	@Override
	public void itemLookup(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") ItemLookupRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<ItemLookupRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Items",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Items>> items) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void browseNodeLookup(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") BrowseNodeLookupRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<BrowseNodeLookupRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "BrowseNodes",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<BrowseNodes>> browseNodes) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void similarityLookup(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") SimilarityLookupRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<SimilarityLookupRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Items",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Items>> items) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cartGet(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") CartGetRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<CartGetRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Cart",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Cart>> cart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cartCreate(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") CartCreateRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<CartCreateRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Cart",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Cart>> cart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cartAdd(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") CartAddRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<CartAddRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Cart",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Cart>> cart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cartModify(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") CartModifyRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<CartModifyRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Cart",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Cart>> cart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cartClear(
			@WebParam(name = "MarketplaceDomain",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String marketplaceDomain,
			@WebParam(name = "AWSAccessKeyId",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String awsAccessKeyId,
			@WebParam(name = "AssociateTag",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String associateTag,
			@WebParam(name = "Validate",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String validate,
			@WebParam(name = "XMLEscaping",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") String xmlEscaping,
			@WebParam(name = "Shared",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") CartClearRequest shared,
			@WebParam(name = "Request",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01") List<CartClearRequest> request,
			@WebParam(name = "OperationRequest",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<OperationRequest> operationRequest,
			@WebParam(name = "Cart",
					  targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01",
					  mode = WebParam.Mode.OUT) Holder<List<Cart>> cart) {
		throw new UnsupportedOperationException();
	}
}
