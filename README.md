# PulTrik

Requirement:
- Java
- Springboot Framework dengan plugin Lombok
- Intelij IDE
- Maven Project
- Mysql

Cara setting koneksi Database:
- Arahkan ke src/main/resources
- Buka file application.properties
- ubah spring.datasource.url = jdbc:mysql://localhost:3306/(nama_database)?useSSL=false
- ubah spring.datasource.username = (username)
- ubah spring.datasource.password = (password)

UI
http://localhost:8080

API
Login
http://localhost:8080/api/login
Method:POST
Parameter Body:
```json
{
	"username": "string",
	"password": "string"
}
```
Response Json:
```json
{
	"status": "0",
	"message": "Sukses",
	"data": {
		"idUser": 1
	}
}
```

InsertUser
http://localhost:8080/api/user
Method : POST
Parameter Body:
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

GetAllUser
Method : GET
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

InsertOperator
http://localhost:8080/api/operator
Method : POST
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

GetAllVoucherByIdOperator
http://localhost:8080/api/voucher/{idOperator}
Method : POST
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

SendTransaction
http://localhost:8080/api/transaksi/{idUser}/{idVoucher}
Method : POST
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
		"noHp": 87808812100,
		"harga": "11500"
	}
}
```
