# Mujeres2000system
Solución web para las emprendedoras de la ONG Mujeres 2000 en la que pueden visualizar el resultado económico del emprendimiento a través de la optimización de los costos y precios.

# APIs

## Usuario

### Registro

**Method:** `POST`

**URL:** `<url>:<port>/usuario/registrar`

**Headers:**
```
Accept: application/json
Content-Type: application/json
```

**Body:** 
```
{
  "email": "<email>",
  "password": "<password>"
}
```

**Responses:**
- Success: 201
- Failure: 400

### Login

**Method:** `POST`

**URL:** `<url>:<port>/usuario/login`

**Headers:**
```
Accept: application/json
Content-Type: application/json
```

**Body:** 
```
{
  "email": "<email>",
  "password": "<password>"
}
```

**Responses:**
- Success: 200

## Producto

### Crear

**Method:** `POST`

**URL:** `<url>:<port>/producto/crear`

**Headers:**
```
Accept: application/json
Content-Type: application/json
```

**Body:** 
```
{
}
```

**Responses:**
- Success: 200

### Borrar
**Method:** `DELETE`

**URL:** `<url>:<port>/producto/borrar`

**Headers:**
```
Accept: application/json
Content-Type: application/json
```

**Body:** 
```
{
}
```
