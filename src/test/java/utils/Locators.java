package utils;

        import org.openqa.selenium.By;

public class Locators {

    /**
     * Login Screen
     */

    public static final By selectBtn = By.id("com.shopback.app:id/btn_select");
    public static final By getStartedBtn = By.id("com.shopback.app:id/skip_button");
    public static final By loginSelectBtn = By.id("com.shopback.app:id/button_account");
    public static final By emailTextField = By.id("com.shopback.app:id/et_email");
    public static final By pswField = By.id("com.shopback.app:id/et_password");
    public static final By signInBtn = By.id("com.shopback.app:id/btn_login");


    /**
     * Home screen
     */
    public static final By pannelSwipeBtn = By.id("com.shopback.app:id/quick_access_panel_marker");
    public static final By shopBackGoBtn = By.id("com.shopback.app:id/iv_logo");

    public static final By userLogoBtn = By.id("com.shopback.app:id/action_account");
    public static final By userSettingLogoBtn = By.id("com.shopback.app:id/setting_image_view");
    public static final By userLogoutBtn = By.id("com.shopback.app:id/logout_button");

    /**
     * Shop back Go Screen
     */
    public static final By shopBackGoTitle = By.id("com.shopback.app:id/iv_shopback_go");
    public static final By shopBackStoreResult = By.id("com.shopback.app:id/outlet_container");
}
