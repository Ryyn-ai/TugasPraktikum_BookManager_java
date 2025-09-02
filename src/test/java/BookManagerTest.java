import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(buku);
        assertEquals(1, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "ErLangga", 2021);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Basis Data");
        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk buku yang memang tidak terdapat pada list
    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        boolean removed = bookManager.removeBook("Algoritma");
        assertFalse(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk mencari buku berdasarkan penulis
    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        Book b1 = new Book("Pemrograman", "Andi", 2020);
        Book b2 = new Book("Struktur Data", "Andi", 2021);
        Book b3 = new Book("Basis Data", "Budi", 2022);

        bookManager.addBook(b1);
        bookManager.addBook(b2);
        bookManager.addBook(b3);

        List<Book> andiBooks = bookManager.findBooksByAuthor("Andi");

        assertEquals(2, andiBooks.size());
        assertTrue(andiBooks.contains(b1));
        assertTrue(andiBooks.contains(b2));
    }

    // Lengkapi Unit Test dibawah untuk seluruh buku yang ada di dalam list
    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        Book b1 = new Book("Pemrograman", "Andi", 2020);
        Book b2 = new Book("Struktur Data", "Andi", 2021);

        bookManager.addBook(b1);
        bookManager.addBook(b2);

        List<Book> allBooks = bookManager.getAllBooks();

        assertEquals(2, allBooks.size());
        assertTrue(allBooks.contains(b1));
        assertTrue(allBooks.contains(b2));
    }
}
