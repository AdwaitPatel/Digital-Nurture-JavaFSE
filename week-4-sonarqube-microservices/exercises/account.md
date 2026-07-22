# Account Microservice

## Endpoint

Method: GET

URL:

```
http://localhost:8080/accounts/{number}
```

Example:

```
http://localhost:8080/accounts/00987987973432
```

Sample Response:

```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343
}
```

## Conclusion

A simple REST microservice that returns dummy account details.