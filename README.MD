# Sistem Presensi Kantor

Sistem Presensi Kantor adalah aplikasi Java yang dirancang untuk memudahkan manajemen kehadiran karyawan. Aplikasi ini dikembangkan menggunakan Visual Studio Code dengan bahasa pemrograman Java dan JavaFX sebagai bagian dari tugas kuliah.

## Deskripsi

Aplikasi ini menyediakan tiga scene utama:
- **Main Scene**: Tempat pengguna memasukkan jumlah karyawan.
- **Detail Scene**: Tempat pengguna memasukkan detail karyawan (nama, ID, jenis karyawan).
- **Output Scene**: Menampilkan kehadiran karyawan dan menyimpannya ke dalam file teks.

## Langkah-Langkah Penggunaan

1. Pastikan Anda memiliki Java Development Kit (JDK) terinstal.
2. Buka proyek ini di Visual Studio Code.
3. Pastikan konfigurasi folder telah disesuaikan (lihat `Folder Structure` pada `README.md`).
4. Jalankan aplikasi dengan menjalankan kelas `SistemPresensiKantor.java`.
5. Masukkan jumlah karyawan di `Main Scene`.
6. Masukkan detail karyawan berupa Nama, ID dan Jenis karyawan di `Detail Scene`.
7. Hasil kehadiran karyawan akan ditampilkan di `Output Scene`.

## Struktur Folder

Aplikasi mengikuti struktur folder standar:
- `shade`: Folder untuk menyimpan file jar setelah package dicompile.
  - `SistemPresensiKantor.jar`: File jar yang sudah dicompile.

- `src`: Folder untuk menyimpan file sumber.
  - `main`: Folder utama untuk kode sumber.
    - `java`: Folder untuk file Java.
      - `com/main`: Package untuk kode Java.
        - `SistemPresensiKantor.java`: Berkas Java untuk aplikasi utama.
        - `MainSceneController.java`: Berkas Java untuk controller Main Scene.
        - `DetailSceneController.java`: Berkas Java untuk controller Detail Scene.
        - `OutputSceneController.java`: Berkas Java untuk controller Output Scene.
    - `resources`: Folder untuk file non-Java.
      - `com/main`: Package untuk file non-Java.
        - `MainScene.fxml`: File FXML untuk Main Scene.
        - `DetailScene.fxml`: File FXML untuk Detail Scene.
        - `OutputScene.fxml`: File FXML untuk Output Scene.
        - `styling.css`: File CSS untuk styling.
        - `assets`: Folder untuk berkas tambahan seperti `background.jpg`.
          - `background.jpg`: Gambar latar belakang.
  - `META-INF`: Folder untuk file manifest.
    - `MANIFEST.MF`: File manifest.

- `target`: Folder output.
  - `SistemPresensiKantor.jar`: Berkas JAR aplikasi.

- `target/classes`: Folder untuk file hasil kompilasi.

Pastikan untuk menempatkan berkas `background.jpg` atau berkas lain yang diperlukan di dalam folder `assets` agar aplikasi dapat mengaksesnya dengan benar.

## Menjalankan Aplikasi

Untuk menjalankan aplikasi, gunakan salah satu dari 2 cara berikut:

1. **Double click SistemPresensiKantor.jar**

    Pastikan bahwa Java sudah terinstall di perangkat Anda.

2. **Jalankan menggunakan `java -jar`:**
    ```bash
    java -jar PATH/TO/SistemPresensiKantor.jar
    ```

    Pastikan untuk mengganti `PATH/TO/SistemPresensiKantor.jar` dengan path lengkap ke file JAR aplikasi Anda.