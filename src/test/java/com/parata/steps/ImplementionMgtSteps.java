package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.constants.CONTEXT;
import com.parata.constants.QUERIES;
import com.parata.pages.ImplementionPage;
import com.parata.utils.Launcher;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import com.parata.utils.services.authorization.DeleteUserRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.parata.utils.context.TestContext;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;



public class ImplementionMgtSteps extends AutomationBase{

    SmartWait smartWait = new SmartWait();
    Launcher launcher = new Launcher(openDriver());
    ImplementionPage implementionPage = new ImplementionPage(openDriver());
}
