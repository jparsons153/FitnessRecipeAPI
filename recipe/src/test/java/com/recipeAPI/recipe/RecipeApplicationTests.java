package com.recipeAPI.recipe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {RecipeApplication.class})
@AutoConfigureMockMvc
class RecipeApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetRecipeByIdSuccessBehavior() throws Exception {
		final long recipeId = 1;

		//set up GET request
		mockMvc.perform(get(("/recipes/" + recipeId)))
				//print response
				.andDo(print())
				//expect status 200 OK
				.andExpect(status().isOk())
				//expect return Content-Type header as application/json
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				//confirm returned JSON values
				.andExpect(jsonPath("id").value(recipeId))
				.andExpect(jsonPath("minutesToMake").value(2))
				.andExpect(jsonPath("reviews", hasSize(1)))
				.andExpect(jsonPath("ingredients", hasSize(1)))
				.andExpect(jsonPath("steps", hasSize(2)));
	}

}
