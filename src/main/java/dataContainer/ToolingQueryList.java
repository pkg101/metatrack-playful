package dataContainer;

public class ToolingQueryList {
	public static String getDeveloperNameQuery(String objectName, String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+order+by+DeveloperName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+order+by+DeveloperName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + enddate + "+order+by+DeveloperName+asc";
			} else {

				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
						+ "+order+by+DeveloperName+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+DeveloperName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+DeveloperName+asc";
			} else {
                
				return "select+Id,DeveloperName,LastModifiedById,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";
			}

		}
	}

	public static String getCustomFields(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+order+by+TableEnumOrId+desc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+order+by+TableEnumOrId+desc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ enddate + "+order+by+TableEnumOrId+desc";
			} else {

				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+TableEnumOrId+desc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+TableEnumOrId+desc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+TableEnumOrId+desc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+TableEnumOrId+desc";
			} else {

				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+TableEnumOrId+desc";
			}

		}
	}

	public static String getCustom_StdObjectFields(String startdate, String enddate, String objectId, String SFDCUserID) {
		
		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + startdate + "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + enddate + "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
					+ "+order+by+DeveloperName+asc";
		}
		}
		else
		{
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='" +  objectId + "'+and+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+DeveloperName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='" +  objectId + "'+and+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='" +  objectId + "'+and+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";
			} else {

				return "select+Id,DeveloperName,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='" +  objectId + "'+and+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+DeveloperName+asc";
			}
		}
			
	}

	public static String getNameQuery(String objectName, String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "where+LastModifiedDate%3E"
						+ startdate + "+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedDate%3E"
						+ enddate + "+order+by+Name+asc";
			} else {

				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";
			} else {

				return "select+Id,Name,LastModifiedById,LastModifiedDate+from+" + objectName + "+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+Name+asc";
			}

		}
	}

	public static String getObjectNameQuery(String CustomObjectId) {
		return "select+Id,DeveloperName+from+CustomObject+where+Id='" + CustomObjectId + "'";
	}

	public static String getCustomObjects() {
		return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+CustomObject";
	}

	public static String getStdObject(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+order+by+TableEnumOrId+desc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+order+by+TableEnumOrId+desc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ enddate + "+order+by+TableEnumOrId+desc";
			} else {

				return "select+Id,LastModifiedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+TableEnumOrId+desc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,TableEnumOrId,LastModifiedById,LastModifiedDate+from+CustomField+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+TableEnumOrId+desc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,TableEnumOrId,LastModifiedById,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+TableEnumOrId+desc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,TableEnumOrId,LastModifiedById,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+TableEnumOrId+desc";
			} else {

				return "select+Id,TableEnumOrId,LastModifiedById,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+TableEnumOrId+desc";
			}
		}
	}

	public static String getAssignmentRules(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ startdate + "+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ enddate + "+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+Name+asc";
			}

		}
	}

	public static String getAutoResponseRules(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ startdate + "+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ enddate + "+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+Name+asc";
			}
		}
	}

	public static String getBusinessProcess(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ startdate + "+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ enddate + "+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";
			} else {

				return "select+Id,Name,EntityDefinitionId,LastModifiedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+Name+asc";
			}
		}
	}

	public static String getRecordType(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ startdate + "+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ enddate + "+order+by+Name+asc";
			} else {

				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+Name+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+Name+asc";
			} else {

				return "select+Id,Name,SobjectType,LastModifiedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+Name+asc";
			}
		}
	}

	public static String getValidationRuleID(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+order+by+ValidationName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ startdate + "+order+by+ValidationName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ enddate + "+order+by+ValidationName+asc";
			} else {

				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+ValidationName+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedById%3D'"
						+ SFDCUserID + "'+order+by+ValidationName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+ValidationName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+ValidationName+asc";
			} else {

				return "select+Id,ValidationName,LastModifiedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
						+ startdate + "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+ValidationName+asc";
			}
		}
	}

	public static String getValidationRuleFullName(String objId) {
		return "select+Id,FullName+from+ValidationRule+where+id='" + objId + "'";
	}
	// -------------------------gupta start-----------------------------

	public static String getWorkflowAlertid(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + startdate + "";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + enddate + "";
			} else {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedDate%3C" + enddate + "";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedById%3D'" + SFDCUserID + "'";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + enddate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'";
			} else {

				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowAlert+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'";
			}
		}
	}

	public static String getWorkflowTaskid(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+order+by+FullName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + startdate
						+ "+order+by+FullName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + enddate
						+ "+order+by+FullName+asc";
			} else {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedDate%3C" + enddate + "";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedById%3D'" + SFDCUserID + "'";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + enddate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'";
			} else {

				return "select+Id,LastModifiedById,LastModifiedDate+from+WorkflowTask+where+LastModifiedDate%3E" + startdate
						+ "+and+LastModifiedDate%3C" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID + "'";
			}
		}
	}

	// -------------------------gupta end-----------------------------
	// -------------------------monty start-----------------------------

	public static String getCompactLayout(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout order by DeveloperName asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate>"
						+ startdate + "+order by DeveloperName asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate<"
						+ enddate + " order by DeveloperName asc";
			} else {

				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate>"
						+ startdate + "and LastModifiedDate<" + enddate + "order by DeveloperName asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedById='"
						+ SFDCUserID + "' order by DeveloperName asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate>"
						+ startdate + " and LastModifiedById='" + SFDCUserID + "' order by DeveloperName asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate<"
						+ enddate + "and LastModifiedById='" + SFDCUserID + "' order by DeveloperName asc";
			} else {

				return "select SobjectType,Id,DeveloperName,LastModifiedDate,LastModifiedById from CompactLayout where LastModifiedDate>"
						+ startdate + " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID
						+ "' order by DeveloperName asc";
			}
		}
	}

	public static String getWorkflowFieldUpdate(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById  from WorkflowFieldUpdate order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById  from WorkflowFieldUpdate where LastModifiedDate>"
						+ startdate + "+order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById  from WorkflowFieldUpdate where LastModifiedDate<"
						+ enddate + " order by Name asc";
			} else {

				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById from WorkflowFieldUpdate where LastModifiedDate>"
						+ startdate + "and LastModifiedDate<" + enddate + "order by Name asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById from WorkflowFieldUpdate where LastModifiedById='"
						+ SFDCUserID + "' order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById from WorkflowFieldUpdate where LastModifiedDate>"
						+ startdate + " and LastModifiedById='" + SFDCUserID + "' order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById from WorkflowFieldUpdate where LastModifiedDate<"
						+ enddate + "and LastModifiedById='" + SFDCUserID + "' order by Name asc";
			} else {

				return "select Id,Name,LastModifiedDate,SourceTableEnumOrId,LastModifiedById from WorkflowFieldUpdate where LastModifiedDate>"
						+ startdate + " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID
						+ "' order by Name asc";
			}
		}
	}

	public static String getWorkflowRule(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById  from WorkflowRule where LastModifiedDate>"
						+ startdate + "+order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedDate<" + enddate
						+ " order by Name asc";
			} else {

				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedDate>"
						+ startdate + "and LastModifiedDate<" + enddate + "order by Name asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedById='"
						+ SFDCUserID + "' order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedDate>"
						+ startdate + " and LastModifiedById='" + SFDCUserID + "' order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedDate<" + enddate
						+ "and LastModifiedById='" + SFDCUserID + "' order by Name asc";
			} else {

				return "select TableEnumOrId,Name,LastModifiedDate,LastModifiedById from WorkflowRule where LastModifiedDate>"
						+ startdate + " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID
						+ "' order by Name asc";
			}
		}
	}

	public static String getLayout(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById  from Layout where LastModifiedDate>" + startdate
						+ "+order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedDate<" + enddate
						+ " order by Name asc";
			} else {

				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedDate>" + startdate
						+ "and LastModifiedDate<" + enddate + "order by Name asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedById='" + SFDCUserID
						+ "' order by Name asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedDate>" + startdate
						+ " and LastModifiedById='" + SFDCUserID + "' order by Name asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedDate<" + enddate
						+ "and LastModifiedById='" + SFDCUserID + "' order by Name asc";
			} else {

				return "select TableEnumOrId,Name,LastModifiedDate,ID,LastModifiedById from Layout where LastModifiedDate>" + startdate
						+ " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID
						+ "' order by Name asc";
			}
		}
	}

	public static String getFlow(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select LastModifiedDate,ID,LastModifiedById from Flow";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select LastModifiedDate,ID,LastModifiedById  from Flow where LastModifiedDate>" + startdate;

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedDate<" + enddate;
			} else {

				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedDate>" + startdate
						+ "and LastModifiedDate<" + enddate;
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedById='" + SFDCUserID + "'";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedDate>" + startdate
						+ " and LastModifiedById='" + SFDCUserID + "'";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedDate<" + enddate
						+ "and LastModifiedById='" + SFDCUserID + "'";
			} else {

				return "select LastModifiedDate,ID,LastModifiedById from Flow where LastModifiedDate>" + startdate
						+ " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID + "'";
			}
		}
	}

	public static String getCustomTab(String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {

			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select LastModifiedDate,ID,LastModifiedById from CustomTab";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select LastModifiedDate,ID,LastModifiedById  from CustomTab where LastModifiedDate>" + startdate;

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedDate<" + enddate;
			} else {

				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedDate>" + startdate
						+ "and LastModifiedDate<" + enddate;
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedById='" + SFDCUserID + "'";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedDate>" + startdate
						+ " and LastModifiedById='" + SFDCUserID + "'";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedDate<" + enddate
						+ "and LastModifiedById='" + SFDCUserID + "'";
			} else {

				return "select LastModifiedDate,ID,LastModifiedById from CustomTab where LastModifiedDate>" + startdate
						+ " and LastModifiedDate<" + enddate + " and LastModifiedById='" + SFDCUserID + "'";
			}
		}
	}
	
	public static String getFlexiPage(String objectName, String startdate, String enddate, String SFDCUserID) {

		if (SFDCUserID.equalsIgnoreCase("") || SFDCUserID == null) {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+order+by+DeveloperName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+order+by+DeveloperName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + enddate + "+order+by+DeveloperName+asc";
			} else {

				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
						+ "+order+by+DeveloperName+asc";
			}
		} else {
			if ((startdate.equalsIgnoreCase("") || startdate == null)
					&& (enddate.equalsIgnoreCase("") || enddate == null)) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";

			} else if (enddate.equalsIgnoreCase("") || enddate == null) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+DeveloperName+asc";

			} else if (startdate.equalsIgnoreCase("") || startdate == null) {
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + enddate + "+and+LastModifiedById%3D'" + SFDCUserID
						+ "'+order+by+DeveloperName+asc";
			} else {
                
				return "select+Id,LastModifiedById,DeveloperName,LastModifiedDate+from+" + objectName
						+ "+where+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
						+ "+and+LastModifiedById%3D'" + SFDCUserID + "'+order+by+DeveloperName+asc";
			}

		}
	}


	public static String getFullnameQuery(String ToolingSobjectName, String ID) {
		String query = "select FullName from " + ToolingSobjectName + " where Id='" + ID + "'";

		return query;

	}
	public static String getUserCred()
	{
		return "select+Id,Name,Username,LastModifiedById,LastModifiedDate+from+User+order+by+Name+asc";

	}
	public static String getUserFullName(String id)
	{
		return "select+Id,Name+from+User+where+Id='"+ id + "'";

	}
	// -------------------------monty end-----------------------------

}
