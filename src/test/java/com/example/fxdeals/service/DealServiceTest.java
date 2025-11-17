    package com.example.fxdeals.service;

    import com.example.fxdeals.dto.DealDto;
    import com.example.fxdeals.entity.DealEntity;
    import com.example.fxdeals.exception.DealAlreadyExistsException;
    import com.example.fxdeals.repository.DealRepository;
    import com.example.fxdeals.service.impl.DealServiceImpl;
    import com.example.fxdeals.validation.DealValidator;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

    class DealServiceTest {

        private DealService service;
        private DealRepository repository;

        @BeforeEach
        void setup() {
            repository = Mockito.mock(DealRepository.class);

            // DealValidator n'est pas utilisé dans ton service → pas besoin
            service = new DealServiceImpl(repository);
        }

        @Test
        void shouldSaveNewDeal() {
            DealDto dto = new DealDto("D-1", "USD", "EUR", 200.0, "2023-10-10T10:10:10");

            Mockito.when(repository.existsById("D-1")).thenReturn(false);

            service.importDeal(dto);

            Mockito.verify(repository).save(Mockito.any(DealEntity.class));
        }

        @Test
        void shouldThrowWhenDealAlreadyExists() {
            DealDto dto = new DealDto("D-1", "USD", "EUR", 100.0, "2023-10-10T10:10:10");

            Mockito.when(repository.existsById("D-1")).thenReturn(true);

            Assertions.assertThrows(
                    DealAlreadyExistsException.class,
                    () -> service.importDeal(dto)
            );
        }
    }
