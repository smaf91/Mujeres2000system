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
  "producto_descripcion": "<producto_descripcion>",
  "costo_materia_prima": "<costo_materia_prima>",
  "rentabilidad": "<rentabilidad>",
  "envio": "<envio>"
}
```

**Responses:**
- Success: 200
- Failure: 400

### Obtener Producto

**Method:** `GET`

**URL:** `<url>:<port>/producto/{producto_ID}`

**Responses:**
- Success: 200
```
{
    "producto_id": 2,
    "producto_nombre": "producto2",
    "producto_descripcion": "producto1",
    "costo_materia_prima": 10.0,
    "envio": 5.0,
    "rentabilidad": 10.0,
    "pdvs": 16.5,
    "costo_general_total": 0.0
}
```
- Failure: 404
```
{
    "error": "Producto no existe"
}
```

### Obtener Lista Producto
**Method:** `GET`

**URL:** `<url>:<port>/producto`

**Responses:**
- Success: 200
```
[
    {
        "producto_id": 2,
        "producto_nombre": "producto2",
        "producto_descripcion": "producto1",
        "costo_materia_prima": 10.0,
        "envio": 5.0,
        "rentabilidad": 10.0,
        "pdvs": 16.5,
        "costo_general_total": 0.0
    },
    {
        "producto_id": 3,
        "producto_nombre": "producto1",
        "producto_descripcion": "producto1",
        "costo_materia_prima": 10.0,
        "envio": 5.0,
        "rentabilidad": 10.0,
        "pdvs": 16.5,
        "costo_general_total": 0.0
    }
]
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
```

## Costo

### Registrar Costo
**Method:** `POST`

**URL:** `<url>:<port>/costo/registrar`

**Body:** 
```
{
    "categoria" : "renta",
    "costo": 30.0
}
```

**Responses:**
- Success: 200

### Listar Costos
**Method:** `GET`

**URL:** `<url>:<port>/costo`

**Responses:**
- Success: 200
```
[
    {
        "costos_generales_ID": 1,
        "categoria": "elec",
        "costo": 30.0
    },
    {
        "costos_generales_ID": 2,
        "categoria": "renta",
        "costo": 30.0
    }
]
```