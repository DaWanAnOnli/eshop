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
- Single Responsibility Principle: Saya memisahkan kelas-kelas (dalam kasus ini interface) sesuai dengan fungsinya, seperti ```CreateAbstractProductInterface```, ```FindAbstractProductInterface```, ```UpdateAbstractProductInterface```, dll.
- Open-Closed Principle: Saya memastikan code pada setiap class tidak bergantung pada subclass dari kelas tersebut atau subclass dari kelas-kelas lain (misalnya untuk kebutuhan parsing), sehingga penambahan fitur dapat dilakukan dengan meng-extend class-class yang sudah ada.
- Liskov Substitution Principle: Karena setiap subclass saya body-nya kosong, otomatis dapat melakukan semua yang dilakukan superclassnya.
- Inteface Segregation Principle: Saya memisahkan masing-masing interface sesuai fungsinya (mirip SRP)
- Dependency Inversion Principle: Semua implementasi konkret me-reference ke interface atau abstract class.
