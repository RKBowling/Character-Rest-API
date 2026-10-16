# Character-Rest-API
this app can create, read, update, and delete characters from Mortal Kombat

# Entity
 | Field | Type | Rules |
|-------|------|-------|
| `id` | Long | Generated automatically |
| `name` | String | Required, not blank |
| `description` | String | Required, not blank |
| `realm` | Enum: `Earthrealm`, `Outworld`, `Edenia`, `Chaosrealm`, `Orderrealm`|Required|
| `newEra` | boolean | Defaults to false |

# Endpoint
Base path: `/api/characters`

| Method | Path | Description | Success |
|--------|------|-------------|---------|
| GET | `/api/characters` | List all mk characters |200 |
| GET | `/api/characters/{id}` | Get one mk character | 200 |
| POST | `/api/characters` | Create a mk character | 201 |
| PUT | `/api/characters/{id}` | Replace a character's fields | 200 |
| DELETE | `/api/plants/{id}` | Delete a character| 204 |

# Example Request

```http
POST /api/characters
Content-Type: application/json

{
  "name": "Liu Kang",
  "description": "Champion of Mortal Kombat",
  "real": "Earthrealm",
  "newEra": true
}
```
# Link
https://mk-character-rest-api.onrender.com/api/characters

# Cold Start 
first request can take up to a minute so please be patience
