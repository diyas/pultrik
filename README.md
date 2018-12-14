# PulTrik

Requirement:
- Java
- Springboot Framework dengan plugin Lombok
- Intelij IDE
- Maven Project
- Mysql(import pultrik.sql) optional

Cara setting koneksi Database:
- Buat Database Mysql
- Arahkan ke src/main/resources
- Buka file application.properties
- ubah spring.datasource.url = jdbc:mysql://localhost:3306/(nama_database)?useSSL=false
- ubah spring.datasource.username = (username_database)
- ubah spring.datasource.password = (password_database)
- Otomatis Tabel akan ter-generate(ddl-auto = update)

# UI Form
http://localhost:8080

# API
#### Login
http://localhost:8080/api/login
##### Method : POST
Parameter Body :
```json
{
	"username": "string",
	"password": "string"
}
```
Response :
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"idUser": 1
	}
}
```

#### Insert User
http://localhost:8080/api/user
##### Method : POST
Parameter Body :
```json
{
	"username": "String",
	"password": "String"
}
```
Response:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"idUser": 1,
		"username": "diyas",
		"password": "pass123"
	}
}
```

#### Get All User
http://localhost:8080/api/user
##### Method : GET
Response:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": [{
		"idUser": 1,
		"username": "diyas",
		"password": "pass123"
	}]
}
```

#### Insert Operator
http://localhost:8080/api/operator
##### Method : POST
Parameter Body:
```json
{
	"nama": "String"
}
```
Response:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"idOperator": 4,
		"nama": "SmartFren"
	}
}
```

#### Get All Operator
http://localhost:8080/api/operator
##### Method : GET
Response:
```json
{
    "status": "0",
    "message": "Sukses",
    "data": [
        {
            "idOperator": 1,
            "nama": "Indosat"
        },
        {
            "idOperator": 2,
            "nama": "Telkomsel"
        },
        {
            "idOperator": 3,
            "nama": "XL"
        },
        {
            "idOperator": 4,
            "nama": "SmartFren"
        }
    ]
}
```

#### Insert Voucher
http://localhost:8080/api/voucher/{idOperator}
##### Method : POST
Parameter Body:
```json
{
	"pulsa": "String",
	"harga": "String"
}
```
Response:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"idVoucher": 3,
		"pulsa": "50",
		"harga": "51000"
	}
}
```

#### Get All Voucher
http://localhost:8080/api/voucher/{idOperator}
##### Method : GET
Response:
```json
{
    "status": "0",
    "message": "Sukses",
    "data": [
        {
            "idVoucher": 1,
            "pulsa": "10",
            "harga": "11500"
        },
        {
            "idVoucher": 2,
            "pulsa": "25",
            "harga": "26000"
        },
        {
            "idVoucher": 3,
            "pulsa": "50",
            "harga": "51000"
        },
        {
            "idVoucher": 4,
            "pulsa": "50",
            "harga": "51000"
        }
    ]
}
```

#### SendTransaction
http://localhost:8080/api/transaksi/{idUser}/{idVoucher}
##### Method : POST
Parameter Body:
```json
{
	"noHp": "String",
	"harga": "String"
}
```
Response:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"id": 3,
		"user": {
			"idUser": 1,
			"username": "diyasck",
			"password": "pass123"
		},
		"voucher": {
			"idVoucher": 1,
			"pulsa": "10",
			"harga": "11500"
		},
		"noHp": "6767676767",
		"harga": "11500"
	}
}
```
