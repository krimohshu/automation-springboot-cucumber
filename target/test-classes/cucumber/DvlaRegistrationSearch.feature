
@DvlaRegistrationSearc
Feature: Dvla vehicle search functionality
  @dvlasearch  @smoke
  Scenario Outline: Search vehicle from dvla vehicle search functionality
   Given I goTo dvla vehicle search page
   When I search vehicle from "<supportedFileTypes>" filetype at "<directoryPath>" location
  # Then vehicle color and modle-make is correct
    Examples:
      | supportedFileTypes               | directoryPath                    |
      | DVLA.xlsx                        | C:/Automation/vehicleManagement/ |
