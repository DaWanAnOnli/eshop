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
#### 2
