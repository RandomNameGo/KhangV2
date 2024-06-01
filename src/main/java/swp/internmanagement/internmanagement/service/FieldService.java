package swp.internmanagement.internmanagement.service;

import swp.internmanagement.internmanagement.payload.response.GetAllFieldsResponse;

public interface FieldService {
    GetAllFieldsResponse getAllFields(int pageNo, int pageSize);
}
