# REST - Get Country by Country Code

## REST API

- @GetMapping maps HTTP GET requests.
- @PathVariable extracts values from the URL.
- Service layer contains the business logic.

## Endpoint

Method: GET

URL:
```

http://localhost:8083/countries/{code}

```

Example:
```

http://localhost:8083/countries/in

```

## Conclusion

- Country code matching is case-insensitive.
- Spring automatically converts the returned object into JSON.