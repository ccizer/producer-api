import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should retrieve person object"

    request {
        method GET()
        url "/api/hello"
        headers { // (5)
            contentType('application/json')
        }
    }

    response {
        body([
                name: "Can",
                surname: "Cizer"
        ])
        status 200
        headers { // (5)
            contentType('application/json')
        }
    }
}
