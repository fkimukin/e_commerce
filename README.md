# Alışveriş Sistemi Backend Servisi

Bu projede, bir online alışveriş sitesinin backend servisini oluşturduk. Bu servis, kullanıcıları, ürünleri ve yorumları yönetmektedir. Serviste aynı kullanıcı adı, telefon numarası veya e-posta ile kayıt yapılamaz ve bir e-posta veya telefon numarası sadece bir kullanıcıya ait olabilir.

## Gereksinimler
* PostgreSQL veritabanı

## Kurulum
1. PostgreSQL veritabanında yeni bir veritabanı oluşturun.

2. application.properties dosyasını açın ve veritabanı bağlantı bilgilerini güncelleyin:


spring.datasource.url=jdbc:postgresql://localhost:5432/veritabani_adi
spring.datasource.username=kullanici_adi
spring.datasource.password=sifre

3. Proje dizininde aşağıdaki komutu çalıştırarak Maven bağımlılıklarını yükleyin:

mvn clean install



## Kullanım
Aşağıda, sağladığımız API rotalarının ve kullanımlarının örneklerini bulabilirsiniz:

Servis, varsayılan olarak http://localhost:8080 adresinde çalışır.

## ENDPOINTS

### Product Controller
* Ürünleri listelemek için GET api/v1/products
* Bir ürünü kaydetmek için POST api/v1/products
* Bir ürünü ID'sine göre getirmek için GET api/v1/products/{id}
* Bir ürünü silmek için DELETE api/v1/products/{id}
* Bir ürünün fiyatını güncellemek için PUT api/v1/products/{id}

### User Controller
* Tüm kullanıcıları getirmek için GET api/v1/users
* Bir kullanıcıyı ID'sine göre getirmek için GET api/v1/users/{id}
* Bir kullanıcıyı kullanıcı adına göre getirmek için GET api/v1/users/username
* Bir kullanıcıyı kaydetmek için POST api/v1/users
* Bir kullanıcıyı silmek için DELETE api/v1/users/{id}
* Bir kullanıcının bilgilerini güncellemek için PUT api/v1/users/{id}

### Comment Controller
* Bir kullanıcının yaptığı yorumları getirmek için GET api/v1/comments/users/{id}
* Bir ürüne yapılan tüm yorumları getirmek için GET api/v1/comments/products/{id} 
* Bir yorumu silmek için DELETE api/v1/comments/{id}
* Tüm yorumları getirmek için GET api/v1/comments
* Bir yorumu ID'sine göre getirmek için GET api/v1/comments/{id}

!!! JWT eklenmedi. isteyen ekleyebilir.

Örnek PostMapping   http://localhost:8080/api/v1/users JSON formatı
{
"firstName":"fatih",
"lastName":"kimukin",
"username":"fkimukin",
"password":"12345",
"email": "fkimukin@gmail.com",
"phoneNumber":"254665665",
"userType":"INDIVIDUAL"

}