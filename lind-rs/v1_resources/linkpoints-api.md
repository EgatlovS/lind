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
	    "fieldDTOs": [{
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

```json

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
	    "fieldDTOs": [{
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

```json

```

## `DELETE /linkpoints/{id}`

Remove a Linkpoint object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X DELETE \ http://localhost:8080/api/linkpoints/10 \
```

### Example Response

```json

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

```
