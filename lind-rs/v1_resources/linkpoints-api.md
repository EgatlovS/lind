# Linkpoints API

Linkpoints are the specific expression of a Structure. Each Linkpoint belongs to exactly one Structure and needs to have every field of his Parent-Structure.

### [Linkpoints](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#linkpoints-api)

| Endpoint | Description |
| ---- | --------------- |
| [GET /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#get-linkpointsid) | Get Linkpoints by Id |
| [POST /linkpoints/linkpoint](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#post-linkpointslinkpoint) | Create Linkpoint |
| [PUT /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#put-linkpointsid) | Update Linkpoint |
| [DELETE /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#delete-linkpointsid) | Remove Linkpoint |
| [GET /linkpoints/{id}/{fieldname}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#get-linkpointsidfieldname) | Get Field of Linkpoint |

## `GET /linkpoints/{id}`

Returns a linkpoint object.

### Example Request

```json
curl -H 'Accept: application/vnd.egatlovs.v1+json' \ 
    -X GET \ http://localhost:8080/api/linkpoints/7 \
```

### Example Response

```json
{
    "id": 7,
    "name": "linkpointname",
    "structureId": 1,
    "fields": [
        {
            "id": 8,
            "name": "firstField",
            "value": "somevalue",
            "_links": [
                {
                    "params": {
                        "rel": "self",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/linkpoints/7/firstField"
                },
                {
                    "params": {
                        "rel": "structure",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/structures/1"
                },
                {
                    "params": {
                        "rel": "linkpoint",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/linkpoints/7"
                }
            ]
        },
        {
            "id": 9,
            "name": "secondField",
            "value": "somevalue2",
            "_links": [
                {
                    "params": {
                        "rel": "self",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/linkpoints/9/secondField"
                },
                {
                    "params": {
                        "rel": "structure",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/structures/1"
                },
                {
                    "params": {
                        "rel": "linkpoint",
                        "type": "GET"
                    },
                    "href": "http://localhost:8080/api/linkpoints/9"
                }
        }
    ],
    "_links": [
        {
            "params": {
                "rel": "self",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/linkpoints/7"
        },
        {
            "params": {
                "rel": "structure",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/structures/1"
        },
        {
            "params": {
                "rel": "firstField",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/linkpoints/7/firstField"
        },
        {
            "params": {
                "rel": "secondField",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/linkpoints/7/secondField"
        },
        {
            "params": {
                "rel": "update",
                "type": "PUT"
            },
            "href": "http://localhost:8080/api/linkpoints/7"
        },
        {
            "params": {
                "rel": "remove",
                "type": "DELETE"
            },
            "href": "http://localhost:8080/api/linkpoints/7"
        }
    ]
}
```

## `POST /linkpoints/linkpoint`

Creates a Linkpoint object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X POST \ http://localhost:8080/api/linkpoints/linkpoint \ 
    -d '{
	    "name": "linkpointname",
	    "structureId": 1,
	    "fields": [{
		    "name": "firstField",
		    "value": "somevalue"
	    },
	    {
		    "name": "secondField",
	    	"value": "somevalue2"
    	}]
    }'
```

### Example Response

```
Status 201 Created
x-api-version: 1
```

## `PUT /linkpoints/{id}`

Update a Linkpoint object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X PUT \ http://localhost:8080/api/linkpoints/13 \
    -d '{
	    "name": "linkpointname",
	    "structureId": 1,
	    "fields": [{
		    "name": "firstField",
		    "value": "valuesome"
	    },
	    {
		    "name": "secondField",
		    "value": "2valuesome"
	    }]
    }'
```

### Example Response

```
Status 200 Ok
x-api-version: 1
```

## `DELETE /linkpoints/{id}`

Remove a Linkpoint object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X DELETE \ http://localhost:8080/api/linkpoints/10 \
```

### Example Response

```
Status 201 Created
x-api-version: 1
```

## `GET /linkpoints/{id}/{fieldname}`

Get a Field of a Linkpoint object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X GET \ http://localhost:8080/api/linkpoints/13/firstField \
```

### Example Response

```json
{
    "id": 13,
    "name": "firstField",
    "value": "valuesome",
    "_links": [
        {
            "params": {
                "rel": "self",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/linkpoints/7/firstField"
        },
        {
            "params": {
                "rel": "structure",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/structures/1"
        },
        {
            "params": {
                "rel": "linkpoint",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/linkpoints/7"
        }
    ]
}
```
