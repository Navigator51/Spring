package su.goodcat.spring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import su.goodcat.commonlib.domain.UserSearchDTO;
import su.goodcat.spring.domain.docproject.Role;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.domain.lerndomain.Gender;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.impl.SearchUserServiceImpl;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchUserServiceImplTest {
//    @Test
//    public void metod(){
//        //given
//        int a = 214748364;
//        long expected = 46116859840676496L;
//        SearchUserServiceImpl searchUserService = new SearchUserServiceImpl(null);
//        //When
//        long actual = searchUserService.squareNumber(a);
//        //Then
//        assertThat(actual).isEqualTo(expected);
//    }
//    @ParameterizedTest
//    @CsvSource(value = {"2, 4", "-2, 4", "9, 81", "-12, 144", "214748364, 46116859840676496", "-214748364, 46116859840676496"})
//
//    public void metod1(int a, long expected) {
//        //given
//        SearchUserServiceImpl searchUserService = new SearchUserServiceImpl(null);
//        //When
//        long actual = searchUserService.squareNumber(a);
//        //Then
//        assertThat(actual).isEqualTo(expected);
//    }

    @InjectMocks
    private SearchUserServiceImpl service;
    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserByQueryTest(){
        //given
        String query = "ar";
        List<User> userList = List.of(new User(1L, "Karl", "", "Karlovich", null, Gender.MAN, "", null, null, new Role(), "jygf", "jgh", "+7-921-667-78-89", "jhg@kjh.uyt"),
        new User(1L, "Marl", "", "Karch", null, Gender.MAN, "", null, null, new Role(), "ftd", "jg", "+7-921-666-78-89", "jh@kjh.uyt"));
        when(userRepository.getDistinctByNameOrEmail(query, query)).thenReturn(userList);
        //When
        List<UserSearchDTO> userSearchDTOList =  service.getUserByQuery(query);
        //Then
        assertThat(userSearchDTOList).hasSize(2);
        assertThat(userSearchDTOList.get(0).getName()).isEqualTo("Karl");
    }
}
