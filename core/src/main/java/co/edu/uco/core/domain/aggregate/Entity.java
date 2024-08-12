package co.edu.uco.core.domain.aggregate;

public abstract class Entity<ID> {
        private ID id;

        protected void setId(ID id) {
            this.id = id;
        }

        public ID getId() {
            return id;
        }
}
