package greencity.service;

import greencity.dto.favoriteplace.FavoritePlaceDto;
import greencity.dto.place.PlaceByBoundsDto;
import greencity.dto.place.PlaceInfoDto;
import greencity.entity.FavoritePlace;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface FavoritePlaceService {
    /**
     * Save place as favorite for user.
     *
     * @param favoritePlaceDto - dto with favorite_place name, place id and user email
     * @param userEmail        - User email
     * @return FavoritePlaceDto instance
     * @author Zakhar Skaletskyi
     */
    FavoritePlaceDto save(FavoritePlaceDto favoritePlaceDto, String userEmail);

    /**
     * Update favorite place name for user.
     *
     * @param favoritePlaceDto - dto with favorite place name, place id and user email
     * @param userEmail            - User email
     * @return FavoritePlaceDto instance
     * @author Zakhar Skaletskyi
     */

    FavoritePlaceDto update(FavoritePlaceDto favoritePlaceDto, String userEmail);

    /**
     * Find all favorite places by user email.
     *
     * @param email - user's email
     * @return list of FavoritePlaceDto
     * @author Zakhar Skaletskyi
     */
    List<FavoritePlaceDto> findAllByUserEmail(String email);

    /**
     * Delete favorite place by user email and place id or favorite place id.
     * If id>0 then delete by favorite place id. If id<0 then delete by place id.
     *
     * @param placeId        - favorite place id
     * @param userEmail - user's email
     * @return -  id of deleted favorite place
     * @author Zakhar Skaletskyi
     */
    @Transactional
    Long deleteByUserEmailAndPlaceId(Long placeId, String userEmail);

    /**
     * FInd favorite place by id.
     *
     * @param placeId - place id
     * @return FavoritePlace entity
     * @author Zakhar Skaletskyi
     */
    FavoritePlace findByPlaceId(Long placeId);

    /**
     * Method for getting FavoritePlace as Place information.
     *
     * @param favoritePlaceId - favorite place id
     * @return info about place with name from favorite place
     * @author Dmytro Dovhal
     */
    PlaceInfoDto getInfoFavoritePlace(Long favoritePlaceId);

    /**
     * Get favorite place coordinates, id and name.
     *
     * @param id        favorite place
     * @param email - user's email
     * @return PlaceByBoundsDto with name from favorite place
     *
     * @author Zakhar Skaletskyi
     */
    PlaceByBoundsDto getFavoritePlaceWithLocation(Long id, String email);

    /**
     * Find all favorite places names with placeId by user email.
     *
     * @param email - user's email
     * @return list of dto
     * @author Zakhar Skaletskyi
     */
    List<FavoritePlaceDto> getFavoritePlaceWithPlaceId(String email);
}
