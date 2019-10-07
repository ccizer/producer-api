import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should retrieve person object"

    request {
        method GET()
        url "/api/hello"
    }

    response {
        body([
                name: "Can",
                surname: "Cizer"
        ])
        status 200
    }
}
