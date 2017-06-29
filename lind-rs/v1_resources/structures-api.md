# Structures API

Structures describe Linkpoints. Each Structure got n-Linkpoints. You can define many different fields with different types.
Supported Types are: __NUMBER, TEXT, IMAGE, VIDEO, MUSIC, ROLES__
To make sure your fields are absolutely valid on each "implementing" linkpoint, u can set regex validation on each of them.

### [Structures](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#structures-api)

| Endpoint | Description |
| ---- | --------------- |
| [GET /structures](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structures) | Get Structures |
| [GET /structures/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structuresid) | Get Structure by Id |
| [POST /structures/structure](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#post-structuresstructure) | Create Structure |
| [DELETE /structures/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#delete-structuresid) | Remove Structure |
| [GET /structures/{id}/links](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structuresidlinks) | Get Links by Structure Id |

## `GET /structures`

Returns Structure objects.

### Example Request

```json
curl -H 'Accept: application/vnd.egatlovs.v1+json' \ 
    -X GET \ http://localhost:8080/api/structures \
```

### Example Response

```json
[
    {
        "id": 1,
        "name": "test",
        "_links": [
            {
                "params": {
                    "rel": "self",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/structures/1"
            },
            {
                "params": {
                    "rel": "remove",
                    "type": "DELETE"
                },
                "href": "http://localhost:8080/api/structures/1"
            },
            {
                "params": {
                    "rel": "linkpoints",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/structures/1/links"
            }
        ]
    },
    {
        "id": 4,
        "name": "test",
        "_links": [
            {
                "params": {
                    "rel": "self",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/structures/4"
            },
            {
                "params": {
                    "rel": "remove",
                    "type": "DELETE"
                },
                "href": "http://localhost:8080/api/structures/4"
            },
            {
                "params": {
                    "rel": "linkpoints",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/structures/4/links"
            }
        ]
    }
]

```

## `GET /structures/{id}`

Returns a Structure object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X GET \ http://localhost:8080/api/structures/1 \
```

### Example Response

```json
{
    "id": 1,
    "name": "test",
    "description": "testdescription",
    "fieldDefinitions": [
        {
            "id": 2,
            "name": "firstField",
            "type": "TEXT",
            "validationConstraint": ".*",
            "_links": []
        },
        {
            "id": 3,
            "name": "secondField",
            "type": "TEXT",
            "validationConstraint": ".*",
            "_links": []
        }
    ],
    "_links": [
        {
            "params": {
                "rel": "self",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/structures/1"
        },
        {
            "params": {
                "rel": "remove",
                "type": "DELETE"
            },
            "href": "http://localhost:8080/api/structures/1"
        },
        {
            "params": {
                "rel": "linkpoints",
                "type": "GET"
            },
            "href": "http://localhost:8080/api/structures/1/links"
        }
    ]
}
```

## `POST /structures/structure`

Create a Structure object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X POST \ http://localhost:8080/api/structures/structure \
    -d '{
	    "name": "test",
	    "description": "testdescription",
	    "fieldDefinitions": [{
	    	"name": "firstField",
	    	"type": "TEXT",
    		"validationConstraint": ".*"
    	},
    	{
    		"name": "secondField",
    		"type": "TEXT",
    		"validationConstraint": ".*"
    	}]
    }'
```

### Example Response

```
Status 201 Created
x-api-version: 1
```

## `DELETE /structures/{id}`

Remove a Structure object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X DELETE \ http://localhost:8080/api/structures/4 \
```

### Example Response

```
Status 200 Ok
x-api-version: 1
```

## `GET /structures/{id}/links`

Get Links by Structure Id.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X GET \ http://localhost:8080/api/structures/1/links \
```

### Example Response

```json
[
    {
        "id": 7,
        "name": "linkpointname",
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
    },
    {
        "id": 10,
        "name": "linkpointname",
        "_links": [
            {
                "params": {
                    "rel": "self",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/linkpoints/10"
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
                "href": "http://localhost:8080/api/linkpoints/10/firstField"
            },
            {
                "params": {
                    "rel": "secondField",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/linkpoints/10/secondField"
            },
            {
                "params": {
                    "rel": "update",
                    "type": "PUT"
                },
                "href": "http://localhost:8080/api/linkpoints/10"
            },
            {
                "params": {
                    "rel": "remove",
                    "type": "DELETE"
                },
                "href": "http://localhost:8080/api/linkpoints/10"
            }
        ]
    }
]
```
