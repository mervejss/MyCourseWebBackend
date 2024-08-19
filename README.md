I will use PostgreSQL as the database, REACT as the frontend and Spring Boot for the backend. I will develop a website similar to UDEMY, where education and purchases can be made.

MyCourseWebBackend
Proje Açıklaması
MyCourseWebBackend, kurs yönetim sisteminin arka planını sağlayan bir Spring Boot uygulamasıdır. Bu proje, kurs bilgilerini, kullanıcı yorumlarını ve satın alma işlemlerini yönetir. Ayrıca, kullanıcıların kurslarla ilgili işlemlerini gerçekleştirmesine olanak tanır.

İçindekiler
Özellikler
Kurulum
API Dokümantasyonu
Veritabanı Yapısı
Proje Yapısı
Teknolojiler

Özellikler
1. Kullanıcı Yönetimi
Kullanıcı Kaydı: Yeni kullanıcılar kaydolabilir.
Kullanıcı Giriş: Mevcut kullanıcılar sisteme giriş yapabilir.
Kullanıcı Profili: Kullanıcılar profil bilgilerini güncelleyebilir ve görüntüleyebilir.
2. Kurs Yönetimi
Kurs Listeleme: Mevcut kursların listesi görüntülenebilir.
Kurs Detayları: Belirli bir kursun detayları (isim, açıklama, fiyat, vs.) görüntülenebilir.
Kurs Ekleme/Düzenleme: Yöneticiler yeni kurs ekleyebilir veya mevcut kursları düzenleyebilir.
Kurs Silme: Kurslar silinebilir.
3. Yorum ve Puanlama
Yorum Ekleme: Kullanıcılar kurslara yorum yapabilir.
Yorum Güncelleme/Silme: Kullanıcılar kendi yorumlarını güncelleyebilir veya silebilir.
Puanlama: Kullanıcılar kurslara puan verebilir.
4. Satın Alma ve Sipariş Yönetimi
Sipariş Oluşturma: Kullanıcılar kurs satın alma işlemini gerçekleştirebilir.
Sipariş Durumu: Siparişlerin durumu (örneğin: "Sipariş Alındı", "Sipariş Onaylandı") takip edilebilir.
5. API Yönetimi
REST API'ler: Kurslar, kullanıcılar, yorumlar ve siparişler için REST API'ler sağlanır.
Kurulum
Gereksinimler
JDK 11 veya üstü
Maven
PostgreSQL
Kurulum Adımları
Depoyu Klonla:

bash
Kodu kopyala
git clone https://github.com/kullaniciAdi/MyCourseWebBackend.git
Veritabanı Yapılandırması:

PostgreSQL veritabanını oluşturun ve application.properties dosyasına uygun veritabanı bilgilerini ekleyin:

properties
Kodu kopyala
spring.datasource.url=jdbc:postgresql://localhost:5432/mycourseweb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
Bağımlılıkları Yükle:

bash
Kodu kopyala
cd MyCourseWebBackend
mvn clean install
Uygulamayı Başlat:

bash
Kodu kopyala
mvn spring-boot:run
Uygulama varsayılan olarak http://localhost:8080 adresinde çalışacaktır.

API Dokümantasyonu
Kullanıcı API'leri
POST /api/users/register: Yeni kullanıcı kaydı.
POST /api/users/login: Kullanıcı girişi.
GET /api/users/{id}: Kullanıcı profili bilgileri.
Kurs API'leri
GET /api/courses: Tüm kursları listeleme.
GET /api/courses/{id}: Belirli bir kursun detayları.
POST /api/courses: Yeni kurs ekleme.
PUT /api/courses/{id}: Kurs güncelleme.
DELETE /api/courses/{id}: Kurs silme.
Yorum API'leri
POST /api/comments: Yeni yorum ekleme.
PUT /api/comments/{id}: Yorum güncelleme.
DELETE /api/comments/{id}: Yorum silme.
Sipariş API'leri
POST /api/orders: Yeni sipariş oluşturma.
GET /api/orders/{id}: Sipariş detayları.
GET /api/orders/user/{userId}: Kullanıcı sipariş geçmişi.
Veritabanı Yapısı
Users: Kullanıcı bilgilerini içerir.
Courses: Kurs bilgilerini içerir.
Comments: Kurs yorumlarını içerir.
Orders: Kullanıcı siparişlerini içerir.
Proje Yapısı
src/main/java/com/mycourseweb/: Uygulamanın kaynak kodları.
controller/: REST API denetleyicileri.
service/: İş mantığı ve servisler.
repository/: Veri erişim katmanı.
model/: Veritabanı modelleri.
config/: Uygulama yapılandırmaları.
src/main/resources/: Konfigürasyon dosyaları ve SQL betikleri.
src/test/java/: Birim testleri ve entegrasyon testleri.
Teknolojiler
Spring Boot: Java tabanlı uygulama geliştirme çerçevesi.
PostgreSQL: Veritabanı yönetim sistemi.
Maven: Proje yönetim ve yapı aracısı.
JUnit: Birim testi çerçevesi.
