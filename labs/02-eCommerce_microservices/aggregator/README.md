```console
$ curl -sX POST http://localhost:8080/graphql \
-H 'Content-Type: application/json' \
-d '
{
        "query":"{allCustomerOrders(customerId: \"1\", limit: 1){ customerName orders{ orderId } } }"
}
'

{"data":{"allCustomerOrders":{"customerName":"Mario","orders":[{"orderId":"1"}]}}}
```

```console
$ curl -sX POST http://localhost:8080/graphql \
-H 'Content-Type: application/json' \
-d '
{
        "query":"{allCustomerOrders(customerId: \"1\", limit: 1){ customerName customerSurname orders{ orderId } } }"
}
'

{"data":{"allCustomerOrders":{"customerName":"Mario","customerSurname":"Rossi","orders":[{"orderId":"1"}]}}}
```