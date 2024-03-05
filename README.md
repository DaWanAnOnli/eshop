# ESHOP

### Nama: William Joel Matthew Quinn Rompis
### NPM: 2206081843
### Kelas: A

## Modul 1

### Refleksi 1: clean code principles and secure coding practices

Saya sudah memastikan setiap variabel method, dan class pada source-code memiliki nama-nama yang sesuai, sehingga mudah dibaca oleh programmer. Selain itu setiap method yang saya buat hanya menjalankan satu tugas saja. Contohnya method ```findProductById``` di file ```ProductRepository.java```. Method ini hanya menjalankan satu tugas, lalu method lain seperti ```delte``` dapat menggunakannya. Saya menghindari penggunakan komentar berlebihan pada code, kecuali pada bagian fungsional test untuk memisahkan antara step-step yang dilakukan pada aplikasi, seperti membuat produk baru. Untuk error handling saya tidak implementasikan karena fitur edit dan delete hanya melibatkan penekanan satu tombol.

Untuk secure coding, aspek yang relevan untuk modul ini adalah validasi input, yakni saat user menginput nama dan jumlah produk. Namun karena latihan 1 hanya meminta untuk membuat fitur edit dan delete, maka saya tidak mengubah/menambahkan code yang sudah ada pada tutorial.

### Refleksi 2: 

#### 1

- Perasaan setelah membuat unit test: saya merasa membuat unit test cukup seru, karena saya tidak perlu khawatir salah membuat fungsi. Saya juga semakin 'pede' dalam membuat test.
- Jumlah unit test dalam class: setiap constructor dan dan method-method yang ada dalam class perlu dibuat unit test masing-masing.
- Cara memastikan unit test cukup untuk verifikasi program: dengan menguji semua jenis input termasuk input yang tidak valid dan edge-cases.
- Jika code coverage mencapai 100%, belum tentu code tidak memiliki error. Kita harus pastikan setiap jenis input memiliki output yang sesuai, termasuk edge-case dan invalid input.


#### 2

Menurut saya, functional test untuk jumlah item dalam produk list memiliki langkah-langkah yang sangat mirip dengan CreateProductFuntionalTest. Langkah pertama dari kedua tes sama persis, yakni membuat produk baru. Hanya saja tes jumlah item mungkin membutuhkan lebih banyak pembuatan item. Jika setiap pembuatan item ditulis satu-per satu, maka code akan bersifat repetitif; terdapat bagian code pada CreateProductFunctionalTest dan tes jumlah item yang sama persis. Ini akan membuat code tidak 'clean'. 

Solusinya, perlu dibuat method yang berisi implementasi create product, yang disimpan di file yang berbeda dengan kedua file tes. Lalu, kedua tes dapat menggunakan method baru ini untuk melakukan create-product. 


## Modul 2

### Refleksi:

#### 1
Code saya tidak memiliki isu besar, hanya beberapa isu kecil yang cukup trivial untuk diselesaikan:
1) Unused imports: menghapus import-import yang tidak dipakai
2) Import *: mengganti semua import * dengan class spesifiknya saja.
3) Unecessary modifier: menghapus semua modifier public pada method-method yang tidak dipakai di luar package
4) Redundant parentheses: menghapus tanda kurung yang tidak diperlukan.

#### 2
Menurut saya workflow CI/CD yang saya buat telah memenuhi definisi CI/CD.
- CI (Continuous Integration) merupakan proses automasi testing aplikasi. Baik workflow dari ```ci.yml``` ataupun ```pmd.yml``` akan secara otomatis menjalankan testing setelah push, sehingga sudah memenuhi CI.
- CD (Continuous Deployment) merupkana poses automasi deployment aplikasi. Saya menggunakan Koyeb untuk deployment yang terhubung langsung dengan branch main dari repository aplikasi saya. Koyeb akan melakukan deployment aplikasi untuk setiap push/pull request ke branch main yang saya buat, sehingga sudah memenuhi CD.




## Modul 3

### Refleksi:

#### 1
- Single Responsibility Principle: Saya memisahkan kelas-kelas (dalam kasus ini interface) sesuai dengan fungsinya, seperti ```CreateAbstractProductInterface```, ```FindAbstractProductInterface```, ```UpdateAbstractProductInterface```, dll. Namun saya tidak dapat memisahkan ```ProductController``` dari ```CarController```, karena saat saya memasukkan ```CarController``` ke dalam file sendiri, muncul White Page Error, dengan alasan yang tidak jelas.
- Open-Closed Principle: Saya memastikan code pada setiap class tidak bergantung pada subclass dari kelas tersebut atau subclass dari kelas-kelas lain (misalnya untuk kebutuhan parsing), sehingga penambahan fitur dapat dilakukan dengan meng-extend class-class yang sudah ada.
- Liskov Substitution Principle: Karena setiap subclass saya body-nya kosong, otomatis dapat melakukan semua yang dilakukan superclassnya.
- Inteface Segregation Principle: Saya memisahkan masing-masing interface sesuai fungsinya (mirip SRP)
- Dependency Inversion Principle: Semua implementasi konkret me-reference ke interface atau abstract class. Sayangnya saya tidak berhasil menerapkannya antara class-class Service dengan interface Repository karena parameter type tidak support 'implements'.

#### 2
- SRP: code bersifat modular dan dapat dipakai berulang-ulang tanpa harus duplikasi. Contoh: ```FindSpecificProductInterface``` di ```AbstractRepositoryInterface.java```.
- OCP: jika ingin menambah fitur, tidak harus mengedit code yang ada, tinggal diextend saja. Contoh: jika ada model ```RaceCar```, dapat langsung di-extend dari model, service, dan repository ```Car```
- LSP: menjaga kekonsistenan antar superclass dan subclass. Contoh: ```ProductRepository``` dan ```AbstractRepository``` memiliki fungsionaltias yang sama persis, hanya saja untuk tipe data yang berbeda.
- ISP: mengakomodasi pembuatan class-class dengan fungsi spesifik. Contoh: jika memerlukan class spesifik yang dapat menampilkan produk saja, bisa mengimplementasikan ```FindSpecificProductInterface``` saja.
- DIP: memudahkan programmer untuk melihat method-method suatu class tanpa harus melihat isinya. Contoh: class ```AbstractService``` cukup besar. Jika ingin melihat dan menggunakan method-method class ini, dapat langsung dari ```AbstractServiceInterface``` saja.

#### 3
- SRP: menyebabkan banyak duplikasi code. Contoh: method ```FindSpecificProduct``` tidak harus eksklusif dipakai di ```AbstractProductRepository```, namun jika tidak dibuatkan class sendiri, class-class lain yang perlu mencari produk perlu refer ke ```AbstractProductRepository``` walaupun sebenarnya tidak berkaitan sama sekali.
- OCP: perlu mengedit implementasi code yang sudah ada. Contoh: Method yang didalamnya dilakukan pengecekan terhadap setiap jenis produk yang ada. Saat ada produk baru yang muncul, setiap class yang melakukan pengecekan harus diedit -- habis tenaga dan waktu.
- LSP: superclass dan subclass tidak konsisten. Misal subclass yang meng-override salah satu method superclassnya dengan implementasi yang berbeda. Hal ini membingungan programmer yang mengerjakan class-class turunannya, karena seakan-akan masing-masing class punya aturan masing-masing dan subclass dan superclass hanya sekadar kata saja.
- ISP: Security -- kita tidak tahu sebuah class sudah memiliki semua method yang dibutuhkan atau belum. Contoh: AbstractRepository memiliki banyak method, sehingga mungkin promgrammer lupa mengimplementasikan salah satunya. Dengan menggunakan interface, programmer dapat mendeteksi apabila semua method yang dibutuhkan telah terimplementasi atau belum.
- DIP: Programmer harus melihat seluruh implementasi code pada class untuk mengetahui method-method apa yang dimilikinya. Tidak praktis terutama untuk class-class besar seperti
- ```AbstractServiceInterface`


## Modul 3

### Refleksi:

#### 1
Pertanyaan Refleksi:
- Functional Test? Tutorial hanya mengenai unit test, jadi belum ada functional test.
- Edge Cases? Semua kemungkinan pada program sudah dibuatkan tesnya.
- All components fit together? Ini belum dapat dipastikan karena belum dibuat functional test.
- Keyakinan untuk melakukan refactor? Ya, karena semua kemungkinan telah dites, hasil refactor dapat diuji menggunakan test-test yang sama.
- Membantu membuat desain yang baik? Efek ini belum terasa karena TDD memaksa saya membuat test untuk desain yang belum ada.
- Feedback cycle yang cepat? Ya, setiap kali melakukan refactor, jalankan semua test lagi, maka akan muncul feedback mengenai apakah hasil refactoring saya sudah benar atau belum.
- Integration test yang lebih cepat? Tutorial kali ini tidak membahas integration test.
- Menjalankan subset dari test suite? Ya, masing-masing tes dapat dijalankan secara independen.
- Terlalu lama menunggu test? Tidak, karena test yang dipakai pendek-pendek.


#### 2
- Fast: Kecuali setUp kali petama, unit test berjalan dengan cepat (kurang dari 10 detik).
- Isolated: Tidak 100%. Misal untuk ```testEditOrder```, kita perlu membuat ```order``` yang ingin diedit terlebih dahulu. Proses pembuatan order itu sendiri ditest pada ```testCreateOrder```. Sehingga ```testEditOrder``` hanya bisa sukses bila ```testCreateOrder```. Menurut saya tidak ada jalan keluar untuk masalah ini (setidaknya dengan metode testing yang sudah dipelajari). Memang kedua function ini harus dites, dan satu bergantung pada yang lain.
- Repeatable: Ya, jika tidak ada perubahan pada code, hasil test tidak akan berubah juga. Selain itu, setiap variable yang diakses masing-masing test akan direset pada setUp(), sehingga test dapat dijalankan berkali-kali tanpa mengubah bagian code lain.
- Self-Validating: Ya, setiap hasil tes merepresentasikan kondisi sebenarnya dari program, baik success maupun fail.
- Thorough: Ya, tes sudah mencakup semua kemungkinan pada code, termasuk input-input yang salah. 
