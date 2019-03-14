
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.BrowseServiceView;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BrowseServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        DBConnect dbModel = new DBConnect();       
        BrowseServiceView view = new BrowseServiceView();

        List services = dbModel.getServices();
        view.showIt(response, services);
    
    }

}
