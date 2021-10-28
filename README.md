Fantasy Bank
---------------------

* Introduction
* Requirements
* Installation
* Configuration
* Maintainers

INTRODUCTION
------------

Fantasy Bank is a digital banking application. You can register an account by preparing some data: 
name, email, phone number, address, biological mother's name, profile photo, username and password. 
You can have more than one wallet in one account. You can topup, withdraw cash, and make payments 
to PLN and PDAM merchants directly from your wallet.


## Prerequisites

* [Oracle JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

## Installation

Use the package manager [maven](https://maven.apache.org/) to install and build Shopaa app.

```bash
mvn clean install
```

running apps

```bash
java -jar target/shopee-boot
```

## API

####Account
1. GET
* Get All Accounts 

``GET: http://localhost:8081/accounts``

  => This API returns all accounts.

2. POST
* Register An Account

``POST: http://localhost:8081/register``

  => This API returns the Account entity that was created. Need RequestBody of Account without id.

####
Request body:

```json
{
  "name": "Boyce Avenue",
  "email": "boyce@avenue.com",
  "phone": "085434343534",
  "address": "Jl Kebahagiaan",
  "biologicalMomName": "Ariana Grande",
  "accountNumber": "1408978989981111",
  "password": "12345678",
  "userName": "boyceAvenue"
}
```

* Sign In An Account

``POST: http://localhost:8081/signIn``

=> This API returns the token. Need RequestBody of UserCredential (username & password).

####
Request body:

```json
{
  "username": "boyceAvenue",
  "password": "12345678"
}
```

* Upload Profile Picture to An Account

``POST: http://localhost:8081/upload``

=> This API returns String of message. Need RequestPart of image file and id of account.

####Wallet
1. POST
* Create Wallet 

``POST: http://localhost:8081/wallet``

  => This API returns the Wallet entity that was created. Need RequestBody of Wallet without id.

####
Request body:

```json
{
  "name": "Dana Sedikit",
  "balance": 10000,
  "accountId": "8a8ab2a07c412cfb017c412ff8af0000"
}
```

* Saving Money

``POST: http://localhost:8081/saving``

  => This API returns String of message. Need RequestBody of Transaction Entity.

####
Request body:

```json
{
  "walletId": "8a8ab2a07c41691a017c416fa65a0001",
  "nominal": 5000
}
```

* Withdraw Money

``POST: http://localhost:8081/withdrawal``

=> This API returns String of message. Need RequestBody of Transaction Entity.

####
Request body:

```json
{
  "walletId": "8a8ab2a07c45a47a017c45a820340000",
  "nominal": 10000000
}
```

* Pay Bill Merchant

``POST: http://localhost:8081/bill-payment``

=> This API returns String of message. Need RequestBody of Transaction Entity.

####
Request body:

```json
{
  "merchantId": "8a8ab2a07c45a47a017c45a913ca0001"
}
```

####Merchant
1. GET
* Get Merchant By Id

``GET: http://localhost:8081/merchant/{id}``

=> This API returns entity Merchant with the given String of id from PathVariable.

2. POST
* Create Merchant

``POST: http://localhost:8081/merchant``

=> This API returns the Merchant entity that was created. Need RequestBody of Merchant without id.

####
Request body:

```json
{
  "name": "PDAM",
  "bill": 153000,
  "walletId": "8a8ab2a07c45a47a017c45a820340000"
}
```

## Support

Further information email me : [megafatayat9@gmail.com]()

## License

[Apache Software Foundation](https://www.apache.org/licenses/LICENSE-2.0)