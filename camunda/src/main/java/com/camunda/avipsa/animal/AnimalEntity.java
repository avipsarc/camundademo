package com.camunda.avipsa.animal;

import com.camunda.avipsa.exception.CamundaInterviewException;
import com.camunda.avipsa.exception.error.CamundaInterviewError;
import com.camunda.avipsa.response.ImageResponse;
import lombok.Getter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Getter
public enum AnimalEntity {

    CAT("cat", "https://api.thecatapi.com/v1/images/0XYvRd7oD"),
    DOG("dog", "https://place.dog/300/200"),
    BEAR("bear", "https://placebear.com/200/300");

    private final String animal;
    private final String imageUrl;
    private static final Function<CompletableFuture<ImageResponse>, Callback> imageBytesTransformer = imageResponseFuture -> {
        return new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                imageResponseFuture.completeExceptionally(new CamundaInterviewException(CamundaInterviewError.IMAGE_FETCH_FAILED_EXCEPTION, e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    ImageResponse imageResponse = ImageResponse.builder()
                            .image(response.body().bytes())
                            .imageUrl(call.request().url().toString())
                            .build();
                    imageResponseFuture.complete(imageResponse);
                }
                imageResponseFuture.completeExceptionally(new CamundaInterviewException(CamundaInterviewError.IMAGE_FETCH_FAILED_EXCEPTION));
            }
        };
    };;

    AnimalEntity(String animal, String imageUrl) {
        this.animal = animal;
        this.imageUrl = imageUrl;
    }

    public static AnimalEntity getAnimal(String name) throws CamundaInterviewException {
        try {
            return AnimalEntity.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new CamundaInterviewException(CamundaInterviewError.INVALID_ANIMAL_CHOICE_EXCEPTION, exception);
        }
    }

    public static Callback getImageTransformerCallback(CompletableFuture<ImageResponse> imageResponseFuture) {
        return imageBytesTransformer.apply(imageResponseFuture);
    }

}
