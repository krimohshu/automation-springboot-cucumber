$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/DvlaRegistrationSearch.feature");
formatter.feature({
  "line": 3,
  "name": "Dvla vehicle search functionality",
  "description": "",
  "id": "dvla-vehicle-search-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@DvlaRegistrationSearc"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Search vehicle from dvla vehicle search functionality",
  "description": "",
  "id": "dvla-vehicle-search-functionality;search-vehicle-from-dvla-vehicle-search-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@dvlasearch"
    },
    {
      "line": 4,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I goTo dvla vehicle search page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I search vehicle from \"\u003csupportedFileTypes\u003e\" filetype at \"\u003cdirectoryPath\u003e\" location",
  "keyword": "When "
});
formatter.examples({
  "comments": [
    {
      "line": 8,
      "value": "# Then vehicle color and modle-make is correct"
    }
  ],
  "line": 9,
  "name": "",
  "description": "",
  "id": "dvla-vehicle-search-functionality;search-vehicle-from-dvla-vehicle-search-functionality;",
  "rows": [
    {
      "cells": [
        "supportedFileTypes",
        "directoryPath"
      ],
      "line": 10,
      "id": "dvla-vehicle-search-functionality;search-vehicle-from-dvla-vehicle-search-functionality;;1"
    },
    {
      "cells": [
        "DVLA.xlsx",
        "C:/Automation/vehicleManagement/"
      ],
      "line": 11,
      "id": "dvla-vehicle-search-functionality;search-vehicle-from-dvla-vehicle-search-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Search vehicle from dvla vehicle search functionality",
  "description": "",
  "id": "dvla-vehicle-search-functionality;search-vehicle-from-dvla-vehicle-search-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@dvlasearch"
    },
    {
      "line": 4,
      "name": "@smoke"
    },
    {
      "line": 2,
      "name": "@DvlaRegistrationSearc"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I goTo dvla vehicle search page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I search vehicle from \"DVLA.xlsx\" filetype at \"C:/Automation/vehicleManagement/\" location",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.match({
  "location": "DvlaRegistrationStepDef.i_goTo_dvla_vehicle_search_page()"
});
formatter.result({
  "duration": 11522452749,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DVLA.xlsx",
      "offset": 23
    },
    {
      "val": "C:/Automation/vehicleManagement/",
      "offset": 47
    }
  ],
  "location": "DvlaRegistrationStepDef.i_search_vehicle_from_filetype_at_location(String,String)"
});
formatter.result({
  "duration": 24102221078,
  "status": "passed"
});
});