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

```json

```

## `DELETE /structures/{id}`

Remove a Structure object.

### Example Request

```bash
curl -H 'Accept: application/vnd.egatlovs.v1+json' \
    -X DELETE \ http://localhost:8080/api/structures/4 \
```

### Example Response

```json

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

```
