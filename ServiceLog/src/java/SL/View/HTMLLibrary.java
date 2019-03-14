
package SL.View;

public class HTMLLibrary {
    
    public String header(String page) {
        return "<!DOCTYPE html>"
        + "<html>"
        + "<head>"
        + "<meta charset='UTF-8'>"
        + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
        + "<title>" + page + "</title>"
        + "<link rel='stylesheet' type='text/css' href='/ServiceLog/normalize.css'>"
        + "<link rel='stylesheet' type='text/css' href='/ServiceLog/style.css'>"
        + "</head>"
        + "<body>";
    }
    
    public String footer = "</body></html>";
    
    public String createVehicleJSON(String action) {
        return "<script>"
        + "function submit() {"
        + "var vehicle = {"
        + "id: document.getElementById('id').value, "
        + "year: document.getElementById('year').value, "
        + "make: document.getElementById('make').value, "
        + "model: document.getElementById('model').value, "
        + "color: document.getElementById('color').value, "
        + "license: document.getElementById('license').value, "
        + "vin: document.getElementById('vin').value, "
        + "regdate: document.getElementById('regdate').value"
        + "};"
        + "var vehicleJSON = JSON.stringify(vehicle);"
        + "var form = document.createElement('form');"
        + "form.setAttribute('method', 'post');"
        + "form.setAttribute('action', 'ServiceLog');"
        + "var actionField = document.createElement('input');"
        + "actionField.setAttribute('type', 'hidden');"
        + "actionField.setAttribute('name', 'action');"
        + "actionField.setAttribute('value', '" + action + "');"
        + "var JSONField = document.createElement('input');"
        + "JSONField.setAttribute('type', 'hidden');"
        + "JSONField.setAttribute('name', 'data');"
        + "JSONField.setAttribute('value', vehicleJSON);"
        + "form.appendChild(actionField);"
        + "form.appendChild(JSONField);"
        + "document.body.appendChild(form);"
        + "console.log('Vehicle JSON:   ' + vehicleJSON);"
        + "form.submit();"
        + "}"
        + "</script>";
    }
}
