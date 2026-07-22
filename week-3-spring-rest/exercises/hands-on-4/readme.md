# Hands On 4 - Spring Core Load Country from XML

## Spring XML Configuration
- Spring beans can be configured in an XML file.
- Spring IoC Container creates and manages these beans.

## Setter Injection
- Bean properties are injected using `<property>`.

## Steps
1. Configure bean in `country.xml`.
2. Create `Country` class.
3. Load XML using `ClassPathXmlApplicationContext`.
4. Retrieve bean using `getBean()`.

## Conclusion
- Spring creates the object.
- Property values are injected from XML.