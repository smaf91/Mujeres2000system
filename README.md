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
```
{
    "error": "Registro inválido, usuario ya registrado"
}
```
```
{
    "error": "Usuario debe indicar el email"
}
```
```
{
    "error": "Usuario debe indicar el password"
}
```

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
- Failure: 401
```
{
    "error": "Usuario no registrado"
}
```

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
  "producto_nombre": "<producto_nombre>",
  "producto_descripcion": "<producto_descripcion>"
  "costo_materia_prima": "<costo_materia_prima>",
  "rentabilidad": "<rentabilidad>",
  "envio": "<envio>"
}
```

**Responses:**
- Success: 200
- Failure: 400

### BUSCAR

**Method:** `GET`

**URL:** `<url>:<port>/producto/{producto_ID}`

**Responses:**
- Success: 200
- Failure: 404
```
{
    "error": "Producto no existe"
}
```

### Borrar
**Method:** `DELETE`

**URL:** `<url>:<port>/producto/{producto_ID}`

**Responses:**
- Success: 200
- Failure: 404
```
{
    "error": "Producto no existe"
}
