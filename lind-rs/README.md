# LIND RS - Link Distributor RS

Link Distributor RS is a service to make simple CRUD based calls for Linkpoints and structures.

## Overview

The LIND API enables you to develop your own frontends using the features I provide. Features include retrieving data about linkpoints and structures you can also create update and delete them. The following pages list the resources that the LIND API provides. If you have any questions or need help in using this API, please message me at <alex.bogner36@googlemail.com> .

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
    "_links": {
        "teams": "https://api.twitch.tv/kraken/teams",       
        "channel": "https://api.twitch.tv/kraken/channel",
        "user": "https://api.twitch.tv/kraken/user",
        "ingests": "https://api.twitch.tv/kraken/ingests",
        "streams": "https://api.twitch.tv/kraken/streams",
        "search": "https://api.twitch.tv/kraken/search"
    },
    ...
}
```

### Errors

TBA

### Security

## API

### [Structures](/v1_resources/structures-api.md)

| Endpoint | Description |
| ---- | --------------- |
| [GET /structures](/v1_resources/structures-api.md#getStructures) | Get Structures |
| [GET /structures/{id}](/v1_resources/structures-api.md#getStructureById) | Get Structure by Id |
| [POST /structures/structure](/v1_resources/structures-api.md#createStructure) | Create Structure |
| [DELETE /structures/{id}](/v1_resources/structures-api.md#removeStructureById) | Remove Structure |
| [GET /structures/{id}/links](/v1_resources/structures-api.md#getLinkpointsByStructureId) | Get Links by Structure Id |

### [Linkpoints](/v1_resources/linkpoints-api.md)

| Endpoint | Description |
| ---- | --------------- |
| [GET /linkpoints/{id}](/v1_resources/linkpoints-api.md#getLinkpointById) | Get Linkpoints by Id |
| [POST /linkpoints/linkpoint](/v1_resources/linkpoints-api.md#createLinkpoint) | Create Linkpoint |
| [PUT /linkpoints/{id}](/v1_resources/linkpoints-api.md#updateLinkpointById) | Update Linkpoint |
| [DELETE /linkpoints/{id}](/v1_resources/linkpoints-api.md#removeLinkpointById) | Remove Linkpoint |
| [GET /linkpoints/{id}/{fieldname}](/v1_resources/linkpoints-api.md#getLinkpointField) | Get Field of Linkpoint |
