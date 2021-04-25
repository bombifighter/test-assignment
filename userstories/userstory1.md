User Story - Registration
=========================

**Story:** As a customer, I want to be able to register on the YouTube website, so I can get personalized video suggestions.

**Background/Business value**: We want to be able to provide customers a better video-watching experience by letting them register on the website. By providing them personalized videos, they will spend more time using our pages.

**Details:** We provide them a registration interface where they can make their own accounts or connect it with other social media(Facebook, Twitter, Google) platforms.
In order to be able to store all the accounts we create a new table in the database.
We need an email verification service.

**Acceptance Criteria**
 - There is a link on the website that leads the customer to the registration page
 - Fields on the page:
   - username (required)
   - password (required)
   - password again (required)
   - email (required)
   - profile avatar (optional)
 - Verification email sent out to the customer after registration
