package com.smart.parking.client.services;

import com.smart.parking.client.entity.*;
import com.smart.parking.client.exception.ApiRequestException;
import com.smart.parking.client.repository.AuthRepository;
import com.smart.parking.client.repository.FavoriteRepository;
import com.smart.parking.client.repository.ParkingRepository;
import com.smart.parking.client.repository.RatingRepository;
import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.response.*;
import com.smart.parking.client.secuirity.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class ParkingService {


    /*private List<ParkingResponse> parking = new ArrayList<>();
    private List<ParkingResponse> parkingList(){
        Collection<Addresse> locationList = new ArrayList<>();
        locationList.add(new Addresse("Morocco", 33.594151, -7.613411, "Casablanca", "Royal Palace"));
        locationList.add(new Addresse("Morocco", 33.586928, -7.631706, "Casablanca", "Twin Center"));
        locationList.add(new Addresse("Morocco", 33.593166, -7.667281, "Casablanca", "Morocco Mall"));
        locationList.add(new Addresse("Morocco", 33.577249, -7.616184, "Casablanca", "Quartier Habous"));
        locationList.add(new Addresse("Morocco", 33.589631, -7.614785, "Casablanca", "Parc de la Ligue Arabe"));
        locationList.add(new Addresse("Morocco", 33.595321, -7.682387, "Casablanca", "Anfa Place Shopping Center"));
        locationList.add(new Addresse("Morocco", 33.591011, -7.631860, "Casablanca", "Rick's Café"));
        locationList.add(new Addresse("Morocco", 33.595845, -7.616611, "Casablanca", "La Sqala"));
        locationList.add(new Addresse("Morocco", 33.591401, -7.633329, "Casablanca", "Villa des Arts"));
        locationList.add(new Addresse("Morocco", 33.594567, -7.611237, "Casablanca", "Place Mohammed V"));
        locationList.add(new Addresse("Morocco", 33.594567, -7.611237, "Casablanca", "Mohammed V Square"));
        locationList.add(new Addresse("Morocco", 33.548853, -7.652604, "Casablanca", "Parc Sindibad"));
        locationList.add(new Addresse("Morocco", 33.562163, -7.653456, "Casablanca", "Technopark"));
        locationList.add(new Addresse("Morocco", 33.593432, -7.645917, "Casablanca", "Casablanca Marina"));
        locationList.add(new Addresse("Morocco", 33.591715, -7.616260, "Casablanca", "Central Market"));
        locationList.add(new Addresse("Morocco", 33.590652, -7.628597, "Casablanca", "United Nations Square"));
        locationList.add(new Addresse("Morocco", 33.578439, -7.611201, "Casablanca", "Parc de la Jeunesse"));
        // Rabat Locations
        locationList.add(new Addresse("Morocco", 34.023442, -6.830117, "Rabat", "Hassan Tower"));
        locationList.add(new Addresse("Morocco", 34.024221, -6.834521, "Rabat", "Kasbah of the Udayas"));
        locationList.add(new Addresse("Morocco", 34.016271, -6.835551, "Rabat", "Royal Palace of Rabat"));
        locationList.add(new Addresse("Morocco", 34.012144, -6.829679, "Rabat", "Chellah Necropolis"));
        locationList.add(new Addresse("Morocco", 34.006226, -6.844977, "Rabat", "Mohammed V University"));
        locationList.add(new Addresse("Morocco", 34.018088, -6.827760, "Rabat", "Rabat Beach"));
        locationList.add(new Addresse("Morocco", 34.023325, -6.831172, "Rabat", "Medina of Rabat"));
        locationList.add(new Addresse("Morocco", 34.022449, -6.834672, "Rabat", "Mausoleum of Mohammed V"));
        locationList.add(new Addresse("Morocco", 34.012856, -6.838055, "Rabat", "Rabat Archaeological Museum"));
        locationList.add(new Addresse("Morocco", 34.020790, -6.832930, "Rabat", "Andalusian Gardens"));
        locationList.add(new Addresse("Morocco", 34.022167, -6.845123, "Rabat", "National Library of the Kingdom of Morocco"));
        locationList.add(new Addresse("Morocco", 34.024097, -6.834913, "Rabat", "Kasbah Mosque"));
        locationList.add(new Addresse("Morocco", 34.004166, -6.852183, "Rabat", "Museum Mohamed VI of Modern and Contemporary Art"));
        locationList.add(new Addresse("Morocco", 34.008759, -6.857631, "Rabat", "Agdal Gardens"));
        locationList.add(new Addresse("Morocco", 34.020124, -6.827155, "Rabat", "Dar Batha Museum"));
        locationList.add(new Addresse("Morocco", 34.015326, -6.838619, "Rabat", "Bouregreg Marina"));
        locationList.add(new Addresse("Morocco", 34.016102, -6.820910, "Rabat", "Rabat American School"));
        // Marrakech Locations
        locationList.add(new Addresse("Morocco", 31.634155, -7.992115, "Marrakech", "Majorelle Garden"));
        locationList.add(new Addresse("Morocco", 31.621521, -7.983311, "Marrakech", "Koutoubia Mosque"));
        locationList.add(new Addresse("Morocco", 31.625965, -7.989134, "Marrakech", "Jemaa el-Fnaa"));
        locationList.add(new Addresse("Morocco", 31.625386, -7.993361, "Marrakech", "Bahia Palace"));
        locationList.add(new Addresse("Morocco", 31.617359, -7.982575, "Marrakech", "Saadian Tombs"));
        locationList.add(new Addresse("Morocco", 31.631544, -7.992434, "Marrakech", "Marrakech Museum"));
        locationList.add(new Addresse("Morocco", 31.625416, -7.989129, "Marrakech", "Medina of Marrakech"));
        // Fes Locations
        locationList.add(new Addresse("Morocco", 34.062508, -4.977784, "Fes", "Fes el Bali (Medina of Fes)"));
        locationList.add(new Addresse("Morocco", 34.061480, -4.981054, "Fes", "Bou Inania Madrasa"));
        locationList.add(new Addresse("Morocco", 34.061695, -4.981313, "Fes", "Al-Attarine Madrasa"));
        locationList.add(new Addresse("Morocco", 34.065009, -4.971941, "Fes", "Bab Bou Jeloud (Blue Gate)"));
        locationList.add(new Addresse("Morocco", 34.061440, -4.981543, "Fes", "Dar Batha Museum"));
        locationList.add(new Addresse("Morocco", 34.064888, -4.977959, "Fes", "University of Al Quaraouiyine"));
        // Tangier Locations
        locationList.add(new Addresse("Morocco", 35.781497, -5.806450, "Tangier", "Kasbah Museum"));
        locationList.add(new Addresse("Morocco", 35.790548, -5.939122, "Tangier", "Cape Spartel"));
        locationList.add(new Addresse("Morocco", 35.813559, -5.823985, "Tangier", "Hercules Caves"));
        locationList.add(new Addresse("Morocco", 35.777676, -5.806132, "Tangier", "Tangier American Legation Museum"));
        locationList.add(new Addresse("Morocco", 35.773862, -5.810853, "Tangier", "Medina of Tangier"));
        // Agadir Locations
        locationList.add(new Addresse("Morocco", 30.419258, -9.601692, "Agadir", "Agadir Beach"));
        locationList.add(new Addresse("Morocco", 30.423569, -9.606539, "Agadir", "Agadir Oufella (Agadir Hilltop Kasbah)"));
        locationList.add(new Addresse("Morocco", 30.418688, -9.620940, "Agadir", "Valley of the Birds"));
        locationList.add(new Addresse("Morocco", 30.417596, -9.598096, "Agadir", "Souk El Had"));
        List<Image> images = new ArrayList<>();
        images.add(new Image("IMAGE" , "https://d1gymyavdvyjgt.cloudfront.net/drive/images/uploads/headers/ws_cropper/1_0x0_790x520_0x520_bay_parking_guide.jpg" , false));
        images.add(new Image("IMAGE" , "https://imagenes.lainformacion.com/files/image_656_370/uploads/imagenes/2021/11/26/parking-publico.jpeg" , false));
        images.add(new Image("IMAGE" , "https://parkingsanclemente.com/wp-content/uploads/parking-219767_1280-min-1080x675.jpg" , false));
        images.add(new Image("IMAGE" , "https://img.freepik.com/photos-gratuite/parking-vide_1127-3299.jpg?w=2000" , false));
        images.add(new Image("IMAGE" , "https://cdn.futura-sciences.com/sources/images/qr/parking.jpg" , false));
        images.add(new Image("IMAGE" , "https://www.virages.com/Images/Blog/Places-de-Parking.jpg" , false));
        images.add(new Image("IMAGE" , "https://media.istockphoto.com/id/1324853440/photo/parking-lot-in-public-areas.jpg?s=612x612&w=0&k=20&c=ihnKsdOdWFeI-mYHsbTV7GlP0NuTjWVAfvO7Dj6WkbU=" , false));
        images.add(new Image("IMAGE" , "https://assets-global.website-files.com/6413856d54d41b5f298d5953/647ee73e8a11b0e8409f17c8_automobiles-stationnement-parking-souterrain.jpg" , false));
        images.add(new Image("IMAGE" , "https://www.lsa-conso.fr/mediatheque/6/0/5/000273506_896x598_c.png" , false));
        Random random = new Random();
        ParkingMode[] values = ParkingMode.values();
        ParkingType[] parkingType = ParkingType.values();
        int i = 1;
        locationList.forEach((list -> {
            int index = random.nextInt(values.length);
            int index2 = random.nextInt(parkingType.length);
            List<Image> selectedImages = new ArrayList<>();
            int numberOfImagesToSelect = new Random().nextInt(4) + 1; // Randomly select 1 to 4 images
            java.util.Collections.shuffle(images);
            // Add the selected images to the new list
            for (int j = 0; j < numberOfImagesToSelect; j++) {
                Image selectedImage = images.get(j);
                // Update the selected image as needed
                selectedImage = new Image(selectedImage.getType(), selectedImage.getUrl(), true);
                selectedImages.add(selectedImage);
            }
            parking.add(new ParkingResponse(
                    (long) i,
                    list.getNeighborhood() ,
                    list ,
                    (list.getCountry() + " " + list.getCity() + " " + list.getNeighborhood()),
                    (5 + (20 - 5) * random.nextDouble()) ,
                    values[index] ,
                    parkingType[index2] ,
                    (0 + (5 - 0) * random.nextDouble()) ,
                    "/Hours",
                    random.nextBoolean() ,
                    selectedImages
            ));
        }));

        return parking;
    }

    public ParkingResponse GetParkingById(Long _id , GeneralRequest request) {
        parking = parkingList();
        List<ParkingResponse> parkingResponses = new ArrayList<>();
        for (ParkingResponse parkingResponse : parking) {
            if (Objects.equals(parkingResponse.getId(), _id)) {
                return  parkingResponse;
            }
        }
        return null;
    }*/
    private final ParkingRepository parkingRepository;
    private final FavoriteRepository favoriteRepository;
    private final RatingRepository ratingRepository;
    private final AuthRepository authRepository;
    private final JWTUtil jwtUtil ;

    public ParkingService(ParkingRepository parkingRepository, FavoriteRepository favoriteRepository, RatingRepository ratingRepository, AuthRepository authRepository, JWTUtil jwtUtil) {
        this.parkingRepository = parkingRepository;
        this.favoriteRepository = favoriteRepository;
        this.ratingRepository = ratingRepository;
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
    }
    public List<ParkingResponse> findParkingByCity(GeneralRequest request , HttpServletRequest httpServletRequest) {
        List<Parking> parking = parkingRepository.GetParkingByCity(request.getListParking().getCity());;
        List<ParkingResponse> parkingResponses = new ArrayList<>();
        String AuthHeader =httpServletRequest.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }
        Long user;
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Optional<Auth> auth = authRepository.findAuthByEmail(username);
            user = auth.map(Auth::getId).orElse(null);
        } else {
            user = null;
        }
        System.out.println(user);
        parking.forEach(p ->{
            Optional<ParkPictures> defaultPicture = p.getPictures().stream()
                    .filter(ParkPictures::is_default)
                    .findFirst();
            double rating =  0.0;
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
            List<Rating> ratings = ratingRepository.getRatingParking(p.getId());
            if(!ratings.isEmpty()){
                rating = (ratings.stream()
                        .mapToDouble(Rating::getRating)
                        .sum())/ratings.size();
            }

            boolean favorite = !favoriteRepository.getFavoriteParking(user,p.getId()).isEmpty();

            parkingResponses.add(
                    ParkingResponse.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .lng(p.getLng()).lat(p.getLat())
                            .description(p.getDescription())
                            .mode(p.getMode())
                            .pictures(defaultPicture.orElse(null))
                            .capacity(p.getCapacity())
                            .address(p.getCity().getName() + ", " + p.getParkZone().getZone().getName())
                            .street(p.getParkZone().getName())
                            .rating(decimalFormat.format(rating))
                            .favorite(favorite)
                            .build());
        });
        return parkingResponses;
    }

    /*public List<ParkingResponse> findParkingByLocation(GeneralRequest request) {
        ParkingListRequest parkingListRequest = request.getListParking();
        List<ParkingResponse> parkingResponses = new ArrayList<>();
        return parkingResponses;
    } */

    public AboutParkingRes GetAboutParkingById(Long id , HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }
        boolean favorite = false;
        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        List<Rating> ratings = ratingRepository.getRatingParking(p.getId());
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Optional<Auth> auth = authRepository.findAuthByEmail(username);
            if(auth.isPresent()){
                favorite = !favoriteRepository.getFavoriteParking(auth.get().getId(),p.getId()).isEmpty();
            }
        }

        double rating =  0.0;
        if(!ratings.isEmpty()){
            rating = (ratings.stream()
                    .mapToDouble(Rating::getRating)
                    .sum())/ratings.size();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return AboutParkingRes.builder()
                .id(p.getId())
                .name(p.getName())
                .lng(p.getLng()).lat(p.getLat())
                .description(p.getDescription())
                .mode(p.getMode())
                .pictures(p.getPictures().stream()
                        .filter(ParkPictures::is_default)
                        .findFirst().orElse(null))
                .capacity(p.getCapacity())
                .address(p.getCity().getName() + ", " + p.getParkZone().getZone().getName())
                .street(p.getParkZone().getName())
                .rating(decimalFormat.format(rating))
                .favorite(favorite)
                .build();
    }

    public ServicesParkingRes GetServicesParkingById(Long id) {
        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        return  ServicesParkingRes.builder()
                .id(p.getId())
                .typeVehicles(p.getTypeVehicles())
                .options(p.getOptions())
                .capacity(p.getCapacity())
                .build();
    }

    public MediaParkingRes GetMediaParkingById(Long id) {
        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        return  MediaParkingRes.builder()
                .id(p.getId())
                .parkPictures(p.getPictures())
                .build();
    }


    public ReviewsParkingRes GetReviewsParkingById(Long id) {
        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        List<Rating> ratings = ratingRepository.getRatingParking(p.getId());

        return  ReviewsParkingRes.builder()
                .id(p.getId())
                .reviews(ratings)
                .build();
    }

    @Transactional
    public GeneralResponse FavoriteParkingByID(Long id , HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }

        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Optional<Auth> auth = authRepository.findAuthByEmail(username);
            if(auth.isPresent()){
                List<Favorite> favorite = favoriteRepository.getFavoriteParking(auth.get().getId(),p.getId());
                if(!favorite.isEmpty()){
                    //delete favorite parking
                    favoriteRepository.deleteById(favorite.get(0).getId());
                }else{
                    //insert favorite parking
                    favoriteRepository.save(Favorite.builder().auth(auth.get()).parking(p).build());
                }
                return GeneralResponse.builder().message("success").build();
            }
        }
        throw new ApiRequestException("You Must be Connect");
    }





    public List<ParkingResponse>  AuthFavoriteParkingByID(HttpServletRequest request){

        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Optional<Auth> auth = authRepository.findAuthByEmail(username);
            if(auth.isPresent()) {
                List<ParkingResponse> parkingResponses = new ArrayList<>();
                List<Favorite> favorite = favoriteRepository.getAuthFavoriteParking(auth.get().getId());
                favorite.forEach(p ->{
                    Optional<ParkPictures> defaultPicture = p.getParking().getPictures().stream()
                            .filter(ParkPictures::is_default)
                            .findFirst();
                    double rating =  0.0;
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
                    List<Rating> ratings = ratingRepository.getRatingParking(p.getParking().getId());
                    if(!ratings.isEmpty()){
                        rating = (ratings.stream()
                                .mapToDouble(Rating::getRating)
                                .sum())/ratings.size();
                    }
                    parkingResponses.add(
                            ParkingResponse.builder()
                                    .id(p.getId())
                                    .name(p.getParking().getName())
                                    .lng(p.getParking().getLng()).lat(p.getParking().getLat())
                                    .description(p.getParking().getDescription())
                                    .mode(p.getParking().getMode())
                                    .pictures(defaultPicture.orElse(null))
                                    .capacity(p.getParking().getCapacity())
                                    .address(p.getParking().getCity().getName() + ", " + p.getParking().getParkZone().getZone().getName())
                                    .street(p.getParking().getParkZone().getName())
                                    .rating(decimalFormat.format(rating))
                                    .favorite(true)
                                    .build());
                });
                return parkingResponses;
            }

        }
        throw new ApiRequestException("You Must be Connect");
    }




    @Transactional
    public Rating ManageReviewParkingByID(GeneralRequest generalRequest , HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }

        Parking p = parkingRepository.GetParkingById(generalRequest.getReviews().getParking()).orElseThrow();
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Auth auth = authRepository.findAuthByEmail(username).orElseThrow(null);
            Rating rating = findRattingByParkingAndAuth(p.getId() , auth.getId());
            if (rating == null) {
                return ratingRepository.save(Rating.builder()
                        .rating(generalRequest.getReviews().getRating())
                        .description(generalRequest.getReviews().getDescription())
                        .auth(auth)
                        .parking(p)
                        .createdAt(generalRequest.getTimeStamps())
                        .build());
            }else{
                ratingRepository.updateRating(rating.getId() , generalRequest.getReviews().getDescription() , generalRequest.getReviews().getRating());
                return Rating.builder()
                        .id(rating.getId())
                        .rating(generalRequest.getReviews().getRating())
                        .description(generalRequest.getReviews().getDescription())
                        .auth(auth)
                        .createdAt(generalRequest.getTimeStamps())
                        .build();
            }
        }
        throw new ApiRequestException("You Must be Connect");
    }

    public Rating authRatingByParking(Long id , HttpServletRequest request){

        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }

        Parking p = parkingRepository.GetParkingById(id).orElseThrow();
        if(!Token.isEmpty()) {
            String username = jwtUtil.extractUsername(Token);
            Auth auth = authRepository.findAuthByEmail(username).orElseThrow(null);
            Rating rating = findRattingByParkingAndAuth(p.getId() , auth.getId());
            if(rating != null){
                return rating;
            }
            throw new ApiRequestException("qsdfjk:bvqdfjkbgqdjkn");
        }
        return null;
    }
    public Rating findRattingByParkingAndAuth(Long parking , Long auth){
        return ratingRepository.getRatingParkingAndAuth(parking , auth).orElse(null);
    }

    public GeneralResponse DeleteReviewParkingByID(GeneralRequest generalRequest , HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token = "";
        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
            Token = AuthHeader.substring(7);
        }

        Parking p = parkingRepository.GetParkingById(generalRequest.getReviews().getParking()).orElseThrow();
        if(!Token.isEmpty()){
            String username = jwtUtil.extractUsername(Token);
            Auth auth = authRepository.findAuthByEmail(username).orElseThrow(null);
            Rating rating = findRattingByParkingAndAuth(p.getId() , auth.getId());
            if(rating != null){
                ratingRepository.delete(rating);
            }

            return GeneralResponse.builder().message("success").build();
        }
        throw new ApiRequestException("You Must be Connect");
    }
}
