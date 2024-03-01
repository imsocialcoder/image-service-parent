package nl.debijenkorf.imageservice.service.imagedownload;

import nl.debijenkorf.imageservice.config.ImageServiceDownloadConfiguration;
import nl.debijenkorf.imageservice.exception.SourceImageNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ImageDownloadServiceImplTest {

    @Mock
    private ImageServiceDownloadConfiguration imageServiceDownloadConfiguration;

    @InjectMocks
    private ImageDownloadServiceImpl imageDownloadService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void downloadImage_ImageExists_Success() {
        String reference = "existing.jpg";

        when(imageServiceDownloadConfiguration.getRootUrl()).thenReturn("http://example.com");

        byte[] result = imageDownloadService.downloadImage(reference);

        // TODO: Add assertions based on the expected behavior later
        assertArrayEquals(new byte[0], result);
    }
}
