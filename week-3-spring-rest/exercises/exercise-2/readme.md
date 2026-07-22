# REST - Country Web Service

## REST API
- @RestController is used to create REST APIs.
- @RequestMapping maps HTTP requests to controller methods.

## Endpoint

Method: GET

URL:
```

http://localhost:8083/country

```

Response:
```

{
"code":"IN",
"name":"India"
}

```

## Conclusion

- Spring loads the bean from XML.
- Jackson automatically converts the Java object into JSON.