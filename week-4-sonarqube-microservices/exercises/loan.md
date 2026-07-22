# Loan Microservice

## Endpoint

Method: GET

URL:

```
http://localhost:8081/loans/{number}
```

Example:

```
http://localhost:8081/loans/H00987987972342
```

Sample Response:

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```

## Conclusion

A simple REST microservice that returns dummy loan details.