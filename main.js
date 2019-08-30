var i = 0;

function getId() {
    return ++i;
}

function registerEmployee() {
    var flag = validateEmployee();
    if (flag == true) {
        var i = getId();
        document.getElementById("employeeReg").innerHTML = "Employee registered !!<br>Registration number :" + i + "<br><br>";
        document.getElementById("employeeid").value = i + "";
    }
}

function getCharges() {
    var daily;
    var monthly;
    var yearly;
    if (window.vehicleType == "Cycle") {
        daily = 5;
        monthly = 100;
        yearly = 500;
    } else if (window.vehicleType == "Motor Cycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    } else {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }
    window.charges = [daily, monthly, yearly];
    return window.charges;
}

function changeCurrency() {
    var charges = getCharges();
    var tempCharges = [];
    window.currency = document.getElementById("currency").value;
    if (window.currency == "")
        return;
    if (window.currency == "INR") {
        for (var i = 0; i < 3; i++)
            tempCharges.push((Math.round(charges[i] * 71.15) * 100) / 100);
    }
    else if (window.currency == "JPY") {
        charges.forEach(element => {
            tempCharges.push((Math.round(element * 105.41) * 100) / 100);
        });
    } else {
        charges.forEach(element => {
            tempCharges.push(element);
        });
    }
    var content = "<br><table size=40% border='1'>"
        + "<tr>"
        + "<td>Daily </td>"
        + "<td><label id='Daily'>" + window.currency + " " + tempCharges[0] + "</label></td>"
        + "</tr>"
        + "<tr>"
        + "<td>Monthly </td>"
        + "<td><label id='Monthly'>" + window.currency + " " + tempCharges[1] + "</label></td>"
        + "</tr>"
        + "<tr>"
        + "<td>Yearly </td>"
        + "<td><label id='Yearly'>" + window.currency + " " + tempCharges[2] + "</label></td>"
        + "</tr>"
        + "</table><br>"
        + "<label size=40%><input type='radio' name='plan' value='Daily'>"
        + " Daily "
        + "</label>"
        + "<label size=40%><input type='radio' name='plan' value='Monthly'>"
        + " Monthly "
        + "</label>"
        + "<label size=40%><input type='radio' name='plan' value='Yearly'>"
        + " Yearly "
        + "</label><br><br>"
        + "<button type='submit' onclick='getPlan()'>Buy</button>";

    document.getElementById("showCharges").innerHTML = content;
}

function getPlan() {
    var radios = document.getElementsByName("plan");
    var elementChecked;
    var plan;
    for (i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            elementChecked = radios[i].value;
            break;
        }
    }
    if (elementChecked == "Daily") {
        plan = charges[0];
    } else if (elementChecked == "Monthly") {
        plan = charges[1];
    } else {
        plan = charges[2];
    }

    if (window.currency == "INR")
        plan = (Math.round(plan * 71.15) * 100) / 100;
    else if(window.currency == "JPY")
        plan = (Math.round(plan * 105.41) * 100) / 100; 
    
    document.getElementById("planSelection").innerHTML = elementChecked + " plan purchased for " + window.currency + " " + plan + ".";
}

function validateEmployee() {

    var flag = true;
    var regex;

    // Validations.
    var name = document.getElementById("fullname").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmpassword = document.getElementById("confirmpassword").value;
    var contact = document.getElementById("contactnumber").value;

    // Reset labels for errors.
    document.getElementById("fullname-error").innerHTML = "";
    document.getElementById("password-error").innerHTML = "";
    document.getElementById("contactnumber-error").innerHTML = "";
    document.getElementById("email-error").innerHTML = "";

    // Validate name.
    regex = new RegExp("\\d");
    if (name.length < 2 || regex.test(name)) {
        document.getElementById("fullname-error").innerHTML = "<font color='red'>Name should not contain numeric and its length > 2.</font>";
        flag = false;
    }

    // Validate password.
    regex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if (password.length == 0 || password !== confirmpassword) {
        document.getElementById("password-error").innerHTML = "<font color='red'>Password didn't match.</font>";
        flag = false;
    }
    else if (!regex.test(password)) {
        document.getElementById("password-error").innerHTML = "<font color='red'>Password should contains Uppercase, Lowercase,<br> Numeric & Alphanumeric.</font>";
        flag = false;
    }

    // Validate email.
    regex = new RegExp("/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/");
    if (regex.test(email)) {
        document.getElementById("email-error").innerHTML = "<font color='red'>Invalid email.</font>";
        flag = false;
    }

    // Validate Contact.
    regex = new RegExp("([a-zA-Z!@#$%^&*()_+])");
    if (contact.length < 8) {
        document.getElementById("contactnumber-error").innerHTML = "<font color='red'>Contact length < 8.</font>";
        flag = false;
    }
    else if (regex.test(contact)) {
        document.getElementById("contactnumber-error").innerHTML = "<font color='red'>Enter Numbers only.</font>";
        flag = false;
    }

    return flag;
}

function registerVehicle() {
    //getCharges();
    window.vehicleType = document.getElementById("vehicletype").value;
    document.getElementById("vehicleReg").innerHTML = "";
}