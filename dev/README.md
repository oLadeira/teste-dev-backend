# API de Controle de Pacientes 🏥

API desenvolvida lorem

## Tecnologias Utilizadas 🖥️
* Java 11
* Spring Framework (Web, Data)
* Hibernate/JPA
* H2
* Lombok

## Documentação 📝

### Diagrama de Classe
![image](https://user-images.githubusercontent.com/78936074/162012998-49944232-cdf5-40e6-a268-5ade08bebe7f.png)

### Endpoints

| Método | Endereço                        | Descricão                                          
|---|---------------------------------|----------------------------------------------------|
| `POST` | /v1/patients                    | Registra um novo paciente no banco de dados.       |
| `GET` | /v1/patients                    | Recupera todos os pacientes do banco de dados.     |
| `GET` | /v1/patients/{id}               | Recupera um paciente específico baseado em seu ID. |
| `GET` | /v1/patients/higherRiskPatients | Recupera os 10 pacientes com maior risco de vida.  |
| `PUT` | /v1/patients/{id}               | Atualiza informações do paciente.                  |
---
### v1/patients [POST]
#### Corpo da requisição 
    {
        "name": "Henrique Silva",
        "birthDate": "1997-02-07",
        "gender": "MALE",
        "healthProblems": [
            {
                "name": "Tuberculosis",
                "degree": 2
            },
            {
                "name": "Skin Allergy",
                "degree": 2
            }
        ]
    }
#### Corpo da resposta (response 200)

    {
        "id": 65,
        "name": "Henrique Silva",
        "birthDate": "1997-02-07",
        "gender": "MALE",
        "creationDate": "2022-04-06",
        "updateDate": "2022-04-06",
        "healthProblems": [
            {
                "id": 70,
                "name": "Tuberculosis",
                "degree": 2
            },
            {
                "id": 71,
                "name": "Skin Allergy",
                "degree": 2
            }
        ]
    }
---
### v1/patients [GET]
#### Corpo da resposta (response 200)

    {
    "content": [
        {
            "id": 1,
            "name": "José Santana",
            "birthDate": "1997-03-10",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 5,
                    "name": "Asthma",
                    "degree": 2
                },
                {
                    "id": 6,
                    "name": "Rhinitis",
                    "degree": 1
                }
            ]
        },
        {
            "id": 2,
            "name": "Caleb Marcelo da Cruz",
            "birthDate": "2001-01-12",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 7,
                    "name": "Nasch Karatsukovy",
                    "degree": 1
                }
            ]
        },
        {
            "id": 3,
            "name": "Vitor Leonardo Almeida",
            "birthDate": "2000-03-17",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 8,
                    "name": "Nasch Karatsukovy",
                    "degree": 2
                },
                {
                    "id": 9,
                    "name": "Mezujok Yachykov",
                    "degree": 2
                },
                {
                    "id": 10,
                    "name": "Tawqan Sidokovy",
                    "degree": 2
                }
            ]
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 10,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 10,
    "empty": false
    }
---

### v1/patients/{id} [GET]
#### Corpo da resposta (response 200)

    {
    "id": 3,
    "name": "Vitor Leonardo Almeida",
    "birthDate": "2000-03-17",
    "gender": "MALE",
    "creationDate": "2022-04-06",
    "updateDate": "2022-04-06",
    "healthProblems": [
        {
            "id": 8,
            "name": "Nasch Karatsukovy",
            "degree": 2
        },
        {
            "id": 9,
            "name": "Mezujok Yachykov",
            "degree": 2
        },
        {
            "id": 10,
            "name": "Tawqan Sidokovy",
            "degree": 2
        }
    ]
    }
---

### v1/patients/higherRiskPatients [GET]
#### Corpo da resposta (response 200)
    [
        {
            "id": 3,
            "name": "Vitor Leonardo Almeida",
            "birthDate": "2000-03-17",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 8,
                    "name": "Nasch Karatsukovy",
                    "degree": 2
                },
                {
                    "id": 9,
                    "name": "Mezujok Yachykov",
                    "degree": 2
                },
                {
                    "id": 10,
                    "name": "Tawqan Sidokovy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 36,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 37,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 38,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 45,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 46,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 47,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 51,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 52,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 53,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 15,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 16,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 17,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 60,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 61,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 62,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 54,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 55,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 56,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 39,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 40,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 41,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 24,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 25,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 26,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        },
        {
            "id": 30,
            "name": "Henrique Silva",
            "birthDate": "1997-02-07",
            "gender": "MALE",
            "creationDate": "2022-04-06",
            "updateDate": "2022-04-06",
            "healthProblems": [
                {
                    "id": 31,
                    "name": "Tuberculosis",
                    "degree": 2
                },
                {
                    "id": 32,
                    "name": "Skin Allergy",
                    "degree": 2
                }
            ]
        }
    ]
---

### v1/patients/{id} [PUT]
#### Corpo da requisição
    {
        "name": "José Santanna",
        "gender": "MALE",
        "birthDate": "1997-02-15"
    }

#### Corpo da resposta (response 200)
    {
        "id": 1,
        "name": "José Santanna",
        "birthDate": "1997-02-15",
        "gender": "MALE",
        "creationDate": "2022-04-06",
        "updateDate": "2022-04-06",
        "healthProblems": [
            {
                "id": 5,
                "name": "Asthma",
                "degree": 2
            },
            {
                "id": 6,
                "name": "Rhinitis",
                "degree": 1
            }
        ]
    }
---