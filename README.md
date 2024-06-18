# quarkus--cointinuous-testing-dotenv

this project shows behaviour with env-file when using continuous testing

## run it

`./mvnw quarkus:test`

## current behaviour

### editing includes in `application.properties`

when playing with includes in [application.properties](./src/main/resources/application.properties) tests are reloaded
and `include-`s are used as they should

the downside of this approach in practice would be that you affect your team members or even pipeline if you change it here and
(accidentially) commit your changes.

### editing includes/excludes in `.env`

the right place to play around locally with includes would imho be [.env](.env) as i does not affect team members or pipeline because it
would not be under source-control in a normal setup.
unfortunately uncommenting `QUARKUS_TEST_INCLUDE_TAGS` it does not work here immediately nor does it when hitting `[r]` in colsole.
it does work only with complete restart of `./mvnw quarkus:test`.

but there is some hope as when uncommenting `WHOAMI` does work and break one test after hitting `[r]` in console.
why doesn't `QUARKUS_TEST_INCLUDE_TAGS` work here immediately?

## desired behaviour

wouldn't it be nice when changes in `.env` would immetiately re-execute tests and use `QUARKUS_TEST_INCLUDE_` as it does when
changing
application.properties?
