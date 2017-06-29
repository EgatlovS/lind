# LIND RS - Link Distributor RS

Link Distributor RS is a service to make simple CRUD based calls for Linkpoints and structures.

## Overview

The LIND API enables you to develop your own independent frontends using the features I provide. Features include retrieving data about linkpoints and structures. You can also create update and delete them. The following pages list the resources that the LIND API provides. If you have any questions or need help in using this API, please message me at <alex.bogner36@googlemail.com> .

### API Versions and MIME Types

The current stable API version is **v1**. Clients are allowed to use any version of the api.
__It's *strongly* recommended specifying a version, otherwise version updates might break your application if you've defaulted your requests to use the latest version.__
When specifying a version for a request to the LIND API, set the `Accept` HTTP header to the API version you prefer. This is done by appending a version specifier to the specific MIME type. Responses will have an `x-api-version` header that will indicate which version you received.

You should specify the following MIME type:

```bash
application/vnd.egatlovs[.version]+json
```

The default returned MIME type for requests is always

```bash
application/json
```

### Formats

All data is sent and received as [JSON](http://www.json.org/).

### HATEOAS API

The API is self-describing and u can obtain information for possible or useful requests in relation with your resource.
Every JSON response includes a `_links` object which allows you to navigate the API without having to hardcode any URLs.
For more Information watch this [HATEOAS Article on Dzone](https://dzone.com/articles/hypermedia-support-in-jax-rs-20)


```json
{
    "_links": [
            {
                "params": {
                    "rel": "self",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/linkpoints/13"
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
                "href": "http://localhost:8080/api/linkpoints/13/firstField"
            },
            {
                "params": {
                    "rel": "secondField",
                    "type": "GET"
                },
                "href": "http://localhost:8080/api/linkpoints/13/secondField"
            },
            {
                "params": {
                    "rel": "update",
                    "type": "PUT"
                },
                "href": "http://localhost:8080/api/linkpoints/13"
            },
            {
                "params": {
                    "rel": "remove",
                    "type": "DELETE"
                },
                "href": "http://localhost:8080/api/linkpoints/13"
            }
        ]
    ...
}
```

### Errors

TBA

### Security

## API

### [Structures](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#structures-api)

| Endpoint | Description |
| ---- | --------------- |
| [GET /structures](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structures) | Get Structures |
| [GET /structures/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structuresid) | Get Structure by Id |
| [POST /structures/structure](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#post-structuresstructure) | Create Structure |
| [DELETE /structures/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#delete-structuresid) | Remove Structure |
| [GET /structures/{id}/links](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/structures-api.md#get-structuresidlinks) | Get Links by Structure Id |

### [Linkpoints](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#linkpoints-api)

| Endpoint | Description |
| ---- | --------------- |
| [GET /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#get-linkpointsid) | Get Linkpoints by Id |
| [POST /linkpoints/linkpoint](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#post-linkpointslinkpoint) | Create Linkpoint |
| [PUT /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#put-linkpointsid) | Update Linkpoint |
| [DELETE /linkpoints/{id}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#delete-linkpointsid) | Remove Linkpoint |
| [GET /linkpoints/{id}/{fieldname}](https://github.com/EgatlovS/lind/blob/master/lind-rs/v1_resources/linkpoints-api.md#get-linkpointsidfieldname) | Get Field of Linkpoint |
