package com.example.composepractice.repository

const val MAX_COUNTRY_NUMBER = 10

val countryCodes = setOf(
    "AF" to "Afghanistan",
    "BE" to "Belgium",
    "CX" to "Christmas Island",
    "GL" to "Greenland",
    "HR" to "Croatia",
    "JM" to "Jamaica",
    "MY" to "Malaysia",
    "NO" to "Norway",
    "UG" to "Uganda",
    "AD" to "Andorra",
    "AE" to "United Arab Emirates",
    "AG" to "Antigua and Barbuda",
    "AI" to "Anguilla",
    "AL" to "Albania",
    "AM" to "Armenia",
    "AN" to "Netherlands Antilles",
    "AO" to "Angola",
    "AQ" to "Antarctica",
    "AR" to "Argentina",
    "AS" to "American Samoa",
    "AT" to "Austria",
    "AU" to "Australia",
    "AW" to "Aruba",
    "AX" to "Aland Islands",
    "AZ" to "Azerbaijan",
    "BA" to "Bosnia and Herzegovina",
    "BB" to "Barbados",
    "BD" to "Bangladesh",
    "BE" to "Belgium",
    "BF" to "Burkina Faso",
    "BG" to "Bulgaria",
    "BH" to "Bahrain",
    "BI" to "Burundi",
    "BJ" to "Benin",
    "BM" to "Bermuda",
    "BN" to "Brunei",
    "BO" to "Bolivia",
    "BR" to "Brazil",
    "BS" to "Bahamas",
    "BT" to "Bhutan",
    "BW" to "Botswana",
    "BY" to "Belarus",
    "BZ" to "Belize",
    "CA" to "Canada",
    "CC" to "Cocos Islands",
    "CD" to "Congo",
    "CF" to "Central African Republic",
    "CG" to "Congo",
    "CH" to "Switzerland",
    "CI" to "Cote D'Ivoire",
    "CK" to "Cook Islands",
    "CL" to "Chile",
    "CM" to "Cameroon",
    "CN" to "China",
    "CO" to "Colombia",
    "CR" to "Costa Rica",
    "CU" to "Cuba",
    "CV" to "Cape Verde",
    "CW" to "Curacao",
    "CX" to "Christmas Island",
    "CY" to "Cyprus",
    "CZ" to "Czech Republic",
    "DE" to "Germany",
    "DJ" to "Djibouti",
    "DK" to "Denmark",
    "DM" to "Dominica",
    "DO" to "Dominican Republic",
    "DZ" to "Algeria",
    "EC" to "Ecuador",
    "EE" to "Estonia",
    "EG" to "Egypt",
    "EH" to "Western Sahara",
    "ER" to "Eritrea",
    "ES" to "Spain",
    "ET" to "Ethiopia",
    "FI" to "Finland",
    "FJ" to "Fiji",
    "FK" to "Falkland Islands",
    "FM" to "Micronesia",
    "FO" to "Faroe Islands",
    "FR" to "France",
    "GA" to "Gabon",
    "GB" to "United Kingdom",
    "GD" to "Grenada",
    "GE" to "Georgia",
    "GG" to "Guernsey",
    "GH" to "Ghana",
    "GI" to "Gibraltar",
    "GL" to "Greenland",
    "GM" to "Gambia",
    "GN" to "Guinea",
    "GQ" to "Equatorial Guinea",
    "GR" to "Greece",
    "GS" to "South Georgia and the South Sandwich Islands",
    "GT" to "Guatemala",
    "GU" to "Guam",
    "GW" to "Guinea-Bissau",
    "GY" to "Guyana",
    "HK" to "Hong Kong",
    "HN" to "Honduras",
    "HR" to "Croatia",
    "HT" to "Haiti",
    "HU" to "Hungary",
    "ID" to "Indonesia",
    "IE" to "Ireland",
    "IL" to "Israel",
    "IM" to "Isle of Man",
    "IN" to "India",
    "IQ" to "Iraq",
    "IR" to "Iran",
    "IS" to "Iceland",
    "IT" to "Italy",
    "JE" to "Jersey",
    "JM" to "Jamaica",
    "JO" to "Jordan",
    "JP" to "Japan",
    "KE" to "Kenya",
    "KG" to "Kyrgyzstan",
    "KH" to "Cambodia",
    "KI" to "Kiribati",
    "KM" to "Comoros",
    "KN" to "Saint Kitts And Nevis",
    "KP" to "North Korea",
    "KR" to "Korea",
    "KW" to "Kuwait",
    "KY" to "Cayman Islands",
    "KZ" to "Kazakhstan",
    "LA" to "Laos",
    "LB" to "Lebanon",
    "LC" to "Saint Lucia",
    "LI" to "Liechtenstein",
    "LK" to "Sri Lanka",
    "LR" to "Liberia",
    "LS" to "Lesotho",
    "LT" to "Lithuania",
    "LU" to "Luxembourg",
    "LV" to "Latvia",
    "LY" to "Libya",
    "MA" to "Morocco",
    "MC" to "Monaco",
    "MD" to "Moldova",
    "ME" to "Montenegro",
    "MF" to "Saint Martin",
    "MG" to "Madagascar",
    "MH" to "Marshall Islands",
    "MK" to "Macedonia",
    "ML" to "Mali",
    "MM" to "Myanmar",
    "MN" to "Mongolia",
    "MO" to "Macao",
    "MP" to "Northern Mariana Islands",
    "MQ" to "Martinique",
    "MR" to "Mauritania",
    "MS" to "Montserrat",
    "MT" to "Malta",
    "MU" to "Mauritius",
    "MV" to "Maldives",
    "MW" to "Malawi",
    "MX" to "Mexico",
    "MY" to "Malaysia",
    "MZ" to "Mozambique",
    "NA" to "Namibia",
    "NC" to "New Caledonia",
    "NE" to "Niger",
    "NF" to "Norfolk Island",
    "NG" to "Nigeria",
    "NI" to "Nicaragua",
    "NL" to "Netherlands",
    "NO" to "Norway",
    "NP" to "Nepal",
    "NR" to "Nauru",
    "NU" to "Niue",
    "NZ" to "New Zealand",
    "OM" to "Oman",
    "PA" to "Panama",
    "PE" to "Peru",
    "PF" to "French Polynesia",
    "PG" to "Papua New Guinea",
    "PH" to "Philippines",
    "PK" to "Pakistan",
    "PL" to "Poland",
    "PN" to "Pitcairn",
    "PR" to "Puerto Rico",
    "PS" to "Palestine",
    "PT" to "Portugal",
    "PW" to "Palau",
    "PY" to "Paraguay",
    "QA" to "Qatar",
    "RE" to "Reunion",
    "RO" to "Romania",
    "RS" to "Serbia",
    "RU" to "Russian Federation",
    "RW" to "Rwanda",
    "SA" to "Saudi Arabia",
    "SB" to "Solomon Islands",
    "SC" to "Seychelles",
    "SD" to "Sudan",
    "SE" to "Sweden",
    "SG" to "Singapore",
    "SH" to "Saint Helena",
    "SI" to "Slovenia",
    "SK" to "Slovakia",
    "SL" to "Sierra Leone",
    "SM" to "San Marino",
    "SN" to "Senegal",
    "SO" to "Somalia",
    "SR" to "Suriname",
    "SS" to "South Sudan",
    "ST" to "Sao Tome and Principe",
    "SV" to "El Salvador",
    "SY" to "Syria",
    "SZ" to "Swaziland",
    "TC" to "Turks and Caicos Islands",
    "TD" to "Chad",
    "TF" to "French Southern Territories",
    "TG" to "Togo",
    "TH" to "Thailand",
    "TJ" to "Tajikistan",
    "TK" to "Tokelau",
    "TL" to "Timor-Leste",
    "TM" to "Turkmenistan",
    "TN" to "Tunisia",
    "TO" to "Tonga",
    "TR" to "Turkey",
    "TT" to "Trinidad and Tobago",
    "TV" to "Tuvalu",
    "TW" to "Taiwan",
    "TZ" to "Tanzania",
    "UA" to "Ukraine",
    "UG" to "Uganda",
    "US" to "United States",
    "UY" to "Uruguay",
    "UZ" to "Uzbekistan",
    "VA" to "Vatican",
    "VC" to "Saint Vincent And The Grenadines",
    "VE" to "Venezuela",
    "VG" to "Virgin Islands",
    "VI" to "Virgin Islands",
    "VN" to "Vietnam",
    "VU" to "Vanuatu",
    "WF" to "Wallis and Futuna",
    "WS" to "Samoa",
    "YE" to "Yemen",
    "YT" to "Mayotte",
    "ZA" to "South Africa",
    "ZM" to "Zambia",
    "ZW" to "Zimbabwe"
)


fun getRandomCountry(): Pair<String, String> =
    countryCodes.random()
