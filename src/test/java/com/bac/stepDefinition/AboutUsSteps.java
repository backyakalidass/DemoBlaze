package com.bac.stepDefinition;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.bac.pageObjectOR.AboutUsPageOR;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUsSteps {

	private static final Logger LOGGER = LogManager.getLogger(AboutUsSteps.class);

	@Given("user clicks on AboutUs link")
	public void user_clicks_on_about_us_link() {
		try {
			HomePageOR.getInstance().clickAboutUsLink();
			LOGGER.info("user clicks on AboutUs link");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on play Video button")
	public void user_clicks_on_play_video_button() {
		try {
			CommonUtils.getInstance().explicitWaitVisibilityofElement(AboutUsPageOR.getInstance().getPlayVideoIcon(),
					20);
			AboutUsPageOR.getInstance().clickPlayVideoIcon();
			LOGGER.info("user clicks on Play Video icon on About us page");

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify video played")
	public void verify_video_played() {
		try {
			if (AboutUsPageOR.getInstance().getPause().isDisplayed()) {
				LOGGER.info("Pause button displayed.Verification of video playing is successful");
			} else {
				LOGGER.info("Pause button not displayed.Verification of video playing is unsuccessful");
			}

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Close button in AboutUs Page")
	public void user_clicks_on_close_button_in_about_us_page() {
		try {
			CommonUtils.getInstance().explicitWaitVisibilityofElement(AboutUsPageOR.getInstance().getClose(), 15);
			AboutUsPageOR.getInstance().clickClose();
			LOGGER.info("user clicks on Close button in AboutUs Page");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("About Us Page is closed")
	public void about_us_page_is_closed() {
		try {
			if (HomePageOR.getInstance().getHomeLink().isDisplayed()) {
				LOGGER.info("AboutUs Page is closed successfully");
			} else {
				LOGGER.info("AboutUs Page close unsuccessful");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());

		}

	}

	@When("user clicks on video pause button")
	public void user_clicks_on_video_pause_button() {
		try {
			AboutUsPageOR.getInstance().clickPause();
			LOGGER.info("user clicks on video pause button");

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify video pause")
	public void verify_video_pause() {
		try {
			if(AboutUsPageOR.getInstance().getPlay().isDisplayed()) {
				LOGGER.info("Video Pause verification success");				
			}else {
				LOGGER.info("Video Pause verification unsuccessful");
			}

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}
	@When("user clicks on video unpause or play button")
	public void user_clicks_on_video_unpause_or_play_button() {
	  try {
		  AboutUsPageOR.getInstance().clickPlay();
		  LOGGER.info("user clicks on video unpause or play button");
		
	} catch (Exception e) {
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	@Then("verify video unpause")
	public void verify_video_unpause() {
		  try {
			  if(AboutUsPageOR.getInstance().getPause().isDisplayed()) {
					LOGGER.info("Video UnPause verification success");				
				}else {
					LOGGER.info("Video UnPause verification unsuccessful");
				}
			} catch (Exception e) {
				LOGGER.error(e);
				Assert.fail(e.getMessage());
			}
	}	
	

@When("user clicks on full screen button")
public void user_clicks_on_full_screen_button() {
   try {
	AboutUsPageOR.getInstance().clickFullScreen();
	LOGGER.info("user clicks on Full Screen button");
} catch (Exception e) {
	LOGGER.error(e);
	Assert.fail(e.getMessage());
}
}
@Then("verify video full screen")
public void verify_video_full_screen() {
	   try {
		   if(AboutUsPageOR.getInstance().getNonFullScreen().isDisplayed()) {
			   LOGGER.info("Video Full Screen verification success");
		   }else {
			   LOGGER.info("Video Full Screen verification Unsuccessful");
		   }
			
	   } catch (Exception e) {
	   	LOGGER.error(e);
	   	Assert.fail(e.getMessage());
	   }
}
@When("user clicks on non full screen button")
public void user_clicks_on_non_full_screen_button() {
   try {
	AboutUsPageOR.getInstance().clickNonFullScreen();
	LOGGER.info("user clicks on non full screen button");
} catch (Exception e) {
	LOGGER.error(e);
   	Assert.fail(e.getMessage());
}
}
@Then("verify video non full screen")
public void verify_video_non_full_screen() {
    try {
    	CommonUtils.getInstance().explicitWaitVisibilityofElement(AboutUsPageOR.getInstance().getFullScreen(), 20);
    	 if(AboutUsPageOR.getInstance().getFullScreen().isDisplayed()) {
			   LOGGER.info("Video Non Full Screen verification success");
		   }else {
			   LOGGER.info("Video Non Full Screen verification Unsuccessful");
		   }
		
	} catch (Exception e) {
		LOGGER.error(e);
	   	Assert.fail(e.getMessage());
	}
}

}
