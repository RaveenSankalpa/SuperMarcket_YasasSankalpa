'use strict';

App.factory('InvoiceService', ['$http', '$q', function($http, $q){

	return {
		
		fetchAllInvoices: function() {
					return $http.get('http://localhost:8080/SuperMarket/invoice/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching invoices');
										return $q.reject(errResponse);
									}
							);
			},
			
			getInvoice: function(invoice){
				alert("service called "+invoice.invoiceID);
				return $http.get('http://localhost:8080/SuperMarket/invoice/', invoice)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while fetch invoice');
							return $q.reject(errResponse);
						}
				);
			},
		    
			createInvoice: function(invoice){
					return $http.post('http://localhost:8080/SuperMarket/invoice/', invoice)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating invoice');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateInvoice: function(invoice, id){
					return $http.put('http://localhost:8080/SuperMarket/invoice/'+id, invoice)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating invoice');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteInvoice: function(id){
					return $http.delete('http://localhost:8080/SuperMarket/invoice/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting invoice');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
